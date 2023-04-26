package com.kjb.dongbu.Repository.Store;

import com.kjb.dongbu.Model.Debts;
import com.kjb.dongbu.Model.History;
import com.kjb.dongbu.Repository.DebtsRepository;
import com.kjb.dongbu.Repository.HistoryRepository;
import com.kjb.dongbu.Repository.Jpo.DebtsJpo;
import com.kjb.dongbu.Repository.Jpo.HistoryJpo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class DebtsStore {

    @Autowired
    private DebtsRepository debtsRepository;

    public Debts findById(long id) {
        Optional<DebtsJpo> optionalDebtsJpo = debtsRepository.findById(id);
        return optionalDebtsJpo.map(DebtsJpo::toDomain).orElse(null);
    }
    public long save(Debts debts) {
        DebtsJpo debtsJpo = new DebtsJpo(debts);
        DebtsJpo newDebtsJpo = debtsRepository.save(debtsJpo);
        return newDebtsJpo.getDtCode();

    }
    public List<Debts> findByPaybackDate(long paybackDate) {
        List<DebtsJpo> debtsJpo = debtsRepository.findByPaybackDate(paybackDate);
        return DebtsJpo.toDomains(debtsJpo);
    }
    public List<Debts> findByMemCode(long mcode) {
        List<DebtsJpo> debtsJpo = debtsRepository.findByMemCode(mcode);
        return DebtsJpo.toDomains(debtsJpo);
    }
}
