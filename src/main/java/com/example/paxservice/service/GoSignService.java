package com.example.paxservice.service;

import com.example.paxservice.dto.*;
import com.pax.market.api.sdk.java.api.goinsight.GoInsightApi;

import java.util.List;

public interface GoSignService {
    List<PaxDataDTO> getDataFromApi(int page);
    List<TerminalsInfoDTO> getAdditionalInfo(int page);
    List<QuestionaryDTO> getQuestionaryInfo(int page);
    List<CashierModeDTO> getCashierModeInfo(int page);
    List<SecurityInfoDTO> getSecurityInfoByPage(int page);
}
