package com.kjb.dongbu.Service;

import com.kjb.dongbu.Model.Debts;
import com.kjb.dongbu.Model.Sdo.DebtsCdo;
import com.kjb.dongbu.Model.Sdo.DebtsUdo;
import com.kjb.dongbu.Repository.Store.DebtsStore;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DebtsService {
    private final DebtsStore debtsStore;

    public DebtsService(DebtsStore debtsStore){
        this.debtsStore = debtsStore;
    }

    public long registerDebts(DebtsCdo debtsCdo){
        Debts debts = new Debts(debtsCdo);

        debtsStore.save(debts);
        return debts.getDtCode();
    }

    public List<Debts> findByPaybackDate (long paybackDate) {
        return debtsStore.findByPaybackDate(paybackDate);
    }
    public List<Debts> findByMemCode (long memCode) {
        return debtsStore.findByMemCode(memCode);
    }

    public void modifyDebts (DebtsUdo debtsUdo){
        Debts debts = debtsStore.findById(debtsUdo.getDtCode());

        if (debts.getDtCode() == debtsUdo.getDtCode()) {
            debts.setPaybackDate(debtsUdo.getPaybackDate());
            debts.setPrice(debtsUdo.getPrice());
        }
        debtsStore.save(debts);
    }
}
