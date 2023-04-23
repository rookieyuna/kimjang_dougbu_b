package com.kjb.dongbu.Service;

import com.kjb.dongbu.Model.History;
import com.kjb.dongbu.Model.Member;
import com.kjb.dongbu.Model.Sdo.HistoryCdo;
import com.kjb.dongbu.Model.Sdo.HistoryUdo;
import com.kjb.dongbu.Model.Sdo.MemberCdo;
import com.kjb.dongbu.Model.Sdo.MemberUdo;
import com.kjb.dongbu.Repository.Store.HistoryStore;
import com.kjb.dongbu.Repository.Store.MemberStore;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryService {
    private final HistoryStore historyStore;

    public HistoryService(HistoryStore historyStore){
        this.historyStore = historyStore;
    }

    public long registerHistory(HistoryCdo historyCdo){
        History history = new History(historyCdo);

        historyStore.save(history);
        return history.getHtCode();
    }

    public List<History> findBySdateBetween (long sdate1, long sdate2) {
        return historyStore.findBySdateBetween(sdate1, sdate2);
    }
    public List<History> findBySdate (long sdate) {
        return historyStore.findBySdate(sdate);
    }
    public List<History> findByMemCode (long memCode) {
        return historyStore.findByMemCode(memCode);
    }

    public void modifyHistory (HistoryUdo historyUdo){
        History history = historyStore.findById(historyUdo.getHtCode());

        if (history.getHtCode() == historyUdo.getHtCode()) {
            history.setEdate(historyUdo.getEdate());
            history.setRdate(historyUdo.getRdate());
            history.setPrepaidYn(historyUdo.getPrepaidYn());
            history.setPrepaidPrice(historyUdo.getPrepaidPrice());
            history.setDebtYn(historyUdo.getDebtYn());
            history.setDtCode(historyUdo.getDtCode());
            history.setCardYn(historyUdo.getCardYn());
            history.setTotal(historyUdo.getTotal());
        }
        historyStore.save(history);
    }
}
