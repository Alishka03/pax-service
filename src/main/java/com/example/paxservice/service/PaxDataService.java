package com.example.paxservice.service;

import com.example.paxservice.dto.QuestionaryDTO;

import java.util.List;

public interface PaxDataService {
    void savePaxDataRows(int page);
    void saveAdditionalInfoRows(int page);
    boolean saveQuestionaryData(int page);
    void saveQuestionaryCompositeEntity(List<QuestionaryDTO> list);
    boolean saveQuestionaryList(List<QuestionaryDTO> list);
    boolean saveCashierMode(int page);
    boolean saveSecurityInfo(int page);
}
