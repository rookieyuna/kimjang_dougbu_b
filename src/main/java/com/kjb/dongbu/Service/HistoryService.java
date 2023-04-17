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
        return history.getH_code();
    }

    public List<History> findBySdateBetween (long sdate1, long sdate2) {
        return historyStore.findBySdateBetween(sdate1, sdate2);
    }
    public List<History> findBySdate (long sdate) {
        return historyStore.findBySdate(sdate);
    }
    public List<History> findByMcode (long mcode) {
        return historyStore.findByMcode(mcode);
    }

    public void modifyHistory (HistoryUdo historyUdo){
        History history = historyStore.findById(historyUdo.getH_code());

        if (history.getH_code() == historyUdo.getH_code()) {
            history.setEdate(historyUdo.getEdate());
            history.setRdate(historyUdo.getRdate());
            history.setPrepaid_yn(historyUdo.getPrepaid_yn());
            history.setPrepaid_price(historyUdo.getPrepaid_price());
            history.setDebt_yn(historyUdo.getDebt_yn());
            history.setD_code(historyUdo.getD_code());
            history.setCard_yn(historyUdo.getCard_yn());
            history.setTotal(historyUdo.getTotal());
        }
        historyStore.save(history);
    }
}
