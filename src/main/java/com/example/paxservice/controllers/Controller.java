package com.example.paxservice.controllers;

import com.example.paxservice.service.GoSignServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    private final GoSignServiceImpl goSignService;

    public Controller(GoSignServiceImpl goSignService) {
        this.goSignService = goSignService;
    }

    @GetMapping("/questionary/get-by-page/{page}")
    public ResponseEntity<?> getValue(@PathVariable int page) {
        return new ResponseEntity<>(goSignService.getQuestionaryInfo(page), HttpStatus.OK);
    }

}
