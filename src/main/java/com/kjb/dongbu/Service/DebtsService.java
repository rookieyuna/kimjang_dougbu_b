package com.kjb.dongbu.Service;

import com.kjb.dongbu.Model.Debts;
import com.kjb.dongbu.Repository.Store.DebtsStore;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class DebtsService {
    private final DebtsStore debtsStore;

    public DebtsService(DebtsStore debtsStore){
        this.debtsStore = debtsStore;
    }

    public void registerDebts(long memCode, int debtsPrice, String htCode){
        Debts debts = new Debts();
        debts.setDtCode(htCode);
        debts.setPrice(debtsPrice);
        debts.setMemCode(memCode);

        debtsStore.save(debts);
    }

    public List<Debts> findDebtsByPaybackDate (long paybackDate) {
        //
        return debtsStore.findByPaybackDate(paybackDate);
    }

    public List<Debts> findDebtsByMemCode (long memCode) {
        //
        return debtsStore.findByMemCode(memCode);
    }

    public void modifyDebts (String dtCode){
        Debts debts = debtsStore.findById(dtCode);

        if (Objects.equals(debts.getDtCode(), dtCode)) {
            debts.setPaybackDate(System.currentTimeMillis());
            debts.setPrice(0);
        }
        debtsStore.save(debts);
    }
}
