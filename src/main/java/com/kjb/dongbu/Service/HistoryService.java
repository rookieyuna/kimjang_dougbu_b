package com.kjb.dongbu.Service;

import com.kjb.dongbu.Model.Debts;
import com.kjb.dongbu.Model.History;
import com.kjb.dongbu.Model.Member;
import com.kjb.dongbu.Model.Sdo.*;
import com.kjb.dongbu.Model.Vo.YesOrNo;
import com.kjb.dongbu.Repository.Store.HistoryStore;
import com.kjb.dongbu.Repository.Store.MemberStore;
import com.kjb.dongbu.Repository.Store.ProductStore;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class HistoryService {
    private final HistoryStore historyStore;

    private ProductService productService;
    private DebtsService debtsService;


    public HistoryService(HistoryStore historyStore, ProductService productService, DebtsService debtsService){
        this.historyStore = historyStore;
        this.productService = productService;
        this.debtsService = debtsService;
    }

    public String registerHistory(HistoryCdo historyCdo){
        History history = new History(historyCdo);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        history.setSdate(System.currentTimeMillis());

        String newHtCode = simpleDateFormat.format(history.getSdate())+'_'+historyCdo.getMemCode();
        history.setHtCode(newHtCode);

        List<ProductCdo> productCdos = Arrays.asList(historyCdo.getProductCdos());
        productCdos.forEach((productCdo) -> productService.registerProduct(productCdo, newHtCode));

        // 총 금액 확인
        int totalPrice = productCdos.stream().mapToInt((ProductCdo::getPrice)).sum();
        //[Lamda 참고]int totalPrice = productCdos.stream().mapToInt((item -> item.getPrice())).sum();
        history.setTotal(totalPrice);

        // 외상여부 확인 Todo: 외상테이블PK를 시퀀스보다는 접수내역PK(HtCode)로 동일하게 맞추는건 어떤지?
        int debtsPrice = totalPrice - historyCdo.getPrepaidPrice();
        if(debtsPrice > 0) {
            history.setDebtYn(YesOrNo.Yes);
            debtsService.registerDebts(historyCdo.getMemCode(), debtsPrice, newHtCode);
        } else {
            history.setDebtYn(YesOrNo.No);
        }

        historyStore.save(history);
        return history.getHtCode();
    }

    public List<History> findHistorysBySdateBetween (HistoryUdo historyUdo) {
        return historyStore.findBySdateBetween(historyUdo.getSdate(), historyUdo.getEdate());
    }
    public List<History> findHistorysBySdate (long sdate) {
        return historyStore.findBySdate(sdate);
    }
    public List<History> findHistorysByMemCode (long memCode) {
        return historyStore.findByMemCode(memCode);
    }

    public void modifyHistory (HistoryUdo historyUdo){
        History history = historyStore.findById(historyUdo.getHtCode());

        if (Objects.equals(history.getHtCode(), historyUdo.getHtCode())) {
            history.setEdate(history.getEdate() != 0 ? System.currentTimeMillis(): historyUdo.getEdate());
            history.setRdate(historyUdo.getRdate());
            history.setCardYn(historyUdo.getCardYn());
        }

        if (historyUdo.getPaybackPrice() > 0) {
            history.setDebtYn(YesOrNo.No);
            debtsService.modifyDebts(history.getHtCode());
        }

        historyStore.save(history);
    }
}
