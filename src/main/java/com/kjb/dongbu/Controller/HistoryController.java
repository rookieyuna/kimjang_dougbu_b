package com.kjb.dongbu.Controller;

import com.kjb.dongbu.Model.History;
import com.kjb.dongbu.Model.Member;
import com.kjb.dongbu.Model.Sdo.HistoryCdo;
import com.kjb.dongbu.Model.Sdo.HistoryUdo;
import com.kjb.dongbu.Model.Sdo.MemberCdo;
import com.kjb.dongbu.Model.Sdo.MemberUdo;
import com.kjb.dongbu.Repository.Jpo.HistoryJpo;
import com.kjb.dongbu.Service.HistoryService;
import com.kjb.dongbu.Service.MemberService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/history")
public class HistoryController {

    private final HistoryService historyService;

    public HistoryController(HistoryService historyService) {
        this.historyService = historyService;
    }

    @PostMapping("")
    public String registerHistory(@RequestBody HistoryCdo historyCdo) {
        return historyService.registerHistory(historyCdo);
    }

    @PostMapping("/work")
    public List<History> findBySdateBetween(@RequestBody HistoryUdo historyUdo) {
        return historyService.findHistorysBySdateBetween(historyUdo);
    }

    @PutMapping("")
    public void modifyHistory(@RequestBody HistoryUdo historyUdo) {
        historyService.modifyHistory(historyUdo);
    }
}
