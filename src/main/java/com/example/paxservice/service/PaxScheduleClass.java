package com.example.paxservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Component
@RequiredArgsConstructor
@Slf4j
public class PaxScheduleClass {

    private final PaxDataService paxDataService;
    public static int currentPageOfPaxData = 1;
    public static int currentPageOfAdditionalInfo = 1;
    public static int currentPageOfQuestionary = 1;
    private final Lock lock = new ReentrantLock();

    @Scheduled(fixedRate = 70000)
    public void startScheduler() {
        lock.lock();
        try{
            log.info("TRYING TO GET PAX DATA");
            saveRowsTask();
        } finally {
            lock.unlock();
        }
    }

    @Scheduled(fixedRate = 100000)
    public void startSecondScheduler(){
        lock.lock();
        try {
            log.info("Trying to save additional pax info");
            saveAdditionalInfoTask();
        } finally {
            lock.unlock();
        }
    }

    @Scheduled(fixedRate = 90000)
    public void startSaveingQuestionaryData(){
        lock.lock();
        try {
            log.info("Trying to save questionary data");
            saveQuestionaryValuesTask();
        } finally {
            lock.unlock();
        }
    }


    private void saveRowsTask() {
        paxDataService.savePaxDataRows(currentPageOfPaxData);
        log.info("Saved pax Data. Page " + currentPageOfPaxData);
        currentPageOfPaxData = (currentPageOfPaxData % 200) + 1; // Обновляем параметр с 1 до 1000 и возвращаемся к 1 после 1000
    }

    private void saveAdditionalInfoTask(){
        paxDataService.saveAdditionalInfoRows(currentPageOfAdditionalInfo);
        log.info("Saved additional rows. Page: " + currentPageOfAdditionalInfo);
        currentPageOfAdditionalInfo = (currentPageOfAdditionalInfo % 200) + 1;
    }

    private void saveQuestionaryValuesTask(){
        paxDataService.saveQuestionaryData(currentPageOfQuestionary);
        log.info("Saved Questionary values. Page: " + currentPageOfQuestionary);
        currentPageOfQuestionary = (currentPageOfQuestionary % 200) + 1;
    }


}
