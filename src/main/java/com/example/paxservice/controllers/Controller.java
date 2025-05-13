package com.example.paxservice.controllers;

import com.example.paxservice.dto.CashierModeDTO;
import com.example.paxservice.dto.QuestionaryDTO;
import com.example.paxservice.service.GoSignServiceImpl;
import com.example.paxservice.service.PaxDataService;
import com.pax.market.api.sdk.java.api.goinsight.GoInsightApi;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {
    private final GoSignServiceImpl goSignService;
    private final PaxDataService paxDataService;


    public Controller(GoSignServiceImpl goSignService, PaxDataService paxDataService) {
        this.goSignService = goSignService;
        this.paxDataService = paxDataService;
    }

    @GetMapping("/questionary/get-by-page/{page}")
    public ResponseEntity<?> getValue(@PathVariable int page) {
        return new ResponseEntity<>(goSignService.getQuestionaryInfo(page), HttpStatus.OK);
    }

    @PostMapping("/questionary/save-data/{page}/{time}")
    public ResponseEntity<?> saveValue(@PathVariable int page,@PathVariable String time) {
        GoInsightApi.TimestampRangeType timestampRangeType = GoInsightApi.TimestampRangeType.valueOf(time);
        paxDataService.saveQuestionaryData(page);
        List<QuestionaryDTO> res = goSignService.getQuestionaryInfoByPageAndDate(page,timestampRangeType);
        boolean result = paxDataService.saveQuestionaryList(res);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/cashier-mode/get-by-page/{page}")
    public ResponseEntity<?> getCashierModeValue(@PathVariable int page) {
        return new ResponseEntity<>(goSignService.getCashierModeInfo(page), HttpStatus.OK);
    }
}
