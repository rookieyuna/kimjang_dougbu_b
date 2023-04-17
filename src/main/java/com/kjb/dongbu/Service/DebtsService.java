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
        return debts.getD_code();
    }

    public List<Debts> findByPaybackdate (long paybackdate) {
        return debtsStore.findByPaybackdate(paybackdate);
    }
    public List<Debts> findByMcode (long mcode) {
        return debtsStore.findByMcode(mcode);
    }

    public void modifyDebts (DebtsUdo debtsUdo){
        Debts debts = debtsStore.findById(debtsUdo.getD_code());

        if (debts.getD_code() == debtsUdo.getD_code()) {
            debts.setPayback_date(debtsUdo.getPayback_date());
            debts.setPrice(debtsUdo.getPrice());
        }
        debtsStore.save(debts);
    }
}
