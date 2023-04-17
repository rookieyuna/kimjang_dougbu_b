package com.kjb.dongbu.Controller;

import com.kjb.dongbu.Model.History;
import com.kjb.dongbu.Model.Sdo.DebtsCdo;
import com.kjb.dongbu.Model.Sdo.DebtsUdo;
import com.kjb.dongbu.Model.Sdo.HistoryCdo;
import com.kjb.dongbu.Model.Sdo.HistoryUdo;
import com.kjb.dongbu.Service.DebtsService;
import com.kjb.dongbu.Service.HistoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/debts")
public class DebtsController {

    private final DebtsService debtsService;

    public DebtsController(DebtsService debtsService) {
        this.debtsService = debtsService;
    }

    @PostMapping("")
    public long registerDebts(@RequestBody DebtsCdo debtsCdo) {
        return debtsService.registerDebts(debtsCdo);
    }

    @PutMapping("")
    public void modifyDebts(@RequestBody DebtsUdo debtsUdo) {
        debtsService.modifyDebts(debtsUdo);
    }
}
