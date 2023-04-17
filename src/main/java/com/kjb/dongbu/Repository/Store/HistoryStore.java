package com.kjb.dongbu.Repository.Store;

import com.kjb.dongbu.Model.History;
import com.kjb.dongbu.Model.Member;
import com.kjb.dongbu.Repository.HistoryRepository;
import com.kjb.dongbu.Repository.Jpo.HistoryJpo;
import com.kjb.dongbu.Repository.Jpo.MemberJpo;
import com.kjb.dongbu.Repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class HistoryStore {

    @Autowired
    private HistoryRepository historyRepository;

    public History findById(long id) {
        Optional<HistoryJpo> optionalHistoryJpo = historyRepository.findById(id);
        return optionalHistoryJpo.map(HistoryJpo::toDomain).orElse(null);
    }
    public void save(History history) {
        HistoryJpo historyJpo = new HistoryJpo(history);
        historyRepository.save(historyJpo);
    }
    public List<History> findBySdateBetween(long sdate1, long sdate2) {
        List<HistoryJpo> historyJpos = historyRepository.findBySdateBetween(sdate1, sdate2);
        return HistoryJpo.toDomains(historyJpos);
    }
    public List<History> findBySdate(long sdate) {
        List<HistoryJpo> historyJpos = historyRepository.findBySdate(sdate);
        return HistoryJpo.toDomains(historyJpos);
    }
    public List<History> findByMcode(long mcode) {
        List<HistoryJpo> historyJpos = historyRepository.findByMcode(mcode);
        return HistoryJpo.toDomains(historyJpos);
    }
}
