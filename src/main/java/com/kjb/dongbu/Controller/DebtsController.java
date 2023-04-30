package com.kjb.dongbu.Controller;

import com.kjb.dongbu.Service.DebtsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/debts")
public class DebtsController {

    private final DebtsService debtsService;

    public DebtsController(DebtsService debtsService) {
        this.debtsService = debtsService;
    }

    @PutMapping("")
    public void modifyDebts(@RequestBody String dtCode) {
        debtsService.modifyDebts(dtCode);
    }
}
