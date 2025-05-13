package com.example.paxservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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
    public static int currentPageOfCashierMode = 1;
    public static int currentPageOfSecurityInfo = 1;
    private final Lock lock = new ReentrantLock();

    @Scheduled(fixedRate = 70000)
    public void startScheduler() {
        lock.lock();
        try {
            log.info("TRYING TO GET PAX DATA");
            saveRowsTask();
        } finally {
            lock.unlock();
        }
    }

    @Scheduled(fixedRate = 100000)
    public void startSecondScheduler() {
        lock.lock();
        try {
            log.info("Trying to save additional pax info");
            saveAdditionalInfoTask();
        } finally {
            lock.unlock();
        }
    }

    @Scheduled(fixedRate = 120000)
    public void saveCashierModeTask() {
        lock.lock();
        try {
            log.info("TRYING TO SAVE CASHIER MODE TABLE");
            saveCashierMode();
        } finally {
            lock.unlock();
        }
    }

    @Scheduled(fixedRate = 110000)
    public void startSavingQuestionaryData() {
        lock.lock();
        try {
            log.info("Trying to save questionary data");
            saveQuestionaryValuesTask();
        } finally {
            lock.unlock();
        }
    }

    @Scheduled(fixedRate = 140000)
    public void startSavingSecurityInfo() {
        lock.lock();
        try {
            log.info("Trying to save security info");
            saveSecurityInfo();
        }finally {
            lock.unlock();
        }
    }


    private void saveRowsTask() {
        paxDataService.savePaxDataRows(currentPageOfPaxData);
        log.info("Saved pax Data. Page " + currentPageOfPaxData);
        currentPageOfPaxData = (currentPageOfPaxData % 200) + 1; // Обновляем параметр с 1 до 1000 и возвращаемся к 1 после 1000
    }

    private void saveAdditionalInfoTask() {
        paxDataService.saveAdditionalInfoRows(currentPageOfAdditionalInfo);
        log.info("Saved additional rows. Page: " + currentPageOfAdditionalInfo);
        currentPageOfAdditionalInfo = (currentPageOfAdditionalInfo % 200) + 1;
    }

    private void saveCashierMode() {
        boolean isEmpty = paxDataService.saveCashierMode(currentPageOfCashierMode);
        if (!isEmpty) {
            currentPageOfCashierMode = 1;
        } else {
            if (currentPageOfCashierMode == 2) {
                currentPageOfCashierMode = 1;
            }else{
                currentPageOfQuestionary = (currentPageOfQuestionary % 200) + 1;
            }
        }
    }

    @Transactional
    public void saveSecurityInfo(){
        boolean isEmpty = paxDataService.saveSecurityInfo(currentPageOfSecurityInfo);
        if (!isEmpty) {
            currentPageOfSecurityInfo = 1;
        } else {
            if (currentPageOfSecurityInfo == 2) {
                currentPageOfSecurityInfo = 1;
            }else{
                currentPageOfSecurityInfo = (currentPageOfSecurityInfo % 200) + 1;
            }
        }
    }

    @Transactional
    public void saveQuestionaryValuesTask() {
        boolean isEmpty = paxDataService.saveQuestionaryData(currentPageOfQuestionary);

        if (!isEmpty) {
            log.info("No data found for page {}. Resetting to page 1.", currentPageOfQuestionary);
            currentPageOfQuestionary = 1;
        } else {
            if (currentPageOfQuestionary == 2) {
                log.info("No data found for page {}. Resetting to page 1.", currentPageOfQuestionary);
                currentPageOfQuestionary = 1;
            } else {
                currentPageOfQuestionary = (currentPageOfQuestionary % 200) + 1;
            }
        }
        log.info("Current page of questionary data: " + currentPageOfQuestionary);
    }


}
