package com.example.paxservice.service;

import com.example.paxservice.dto.PaxDataDTO;
import com.example.paxservice.dto.QuestionaryDTO;
import com.example.paxservice.dto.TerminalsInfoDTO;
import com.pax.market.api.sdk.java.api.goinsight.GoInsightApi;

import java.util.List;

public interface GoSignService {
    List<PaxDataDTO> getDataFromApi(int page);
    List<TerminalsInfoDTO> getAdditionalInfo(int page);
    List<QuestionaryDTO> getQuestionaryInfo(int page);
}
