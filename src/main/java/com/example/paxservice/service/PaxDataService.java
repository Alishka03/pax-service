package com.example.paxservice.service;

import com.example.paxservice.dto.QuestionaryDTO;

import java.util.List;

public interface PaxDataService {
    void savePaxDataRows(int page);
    void saveAdditionalInfoRows(int page);
    void saveQuestionaryData(int page);
    void saveQuestionaryCompositeEntity(List<QuestionaryDTO> list);
}
