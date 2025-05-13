package com.example.paxservice.service;

import com.example.paxservice.dto.*;
import com.pax.market.api.sdk.java.api.base.dto.Result;
import com.pax.market.api.sdk.java.api.goinsight.GoInsightApi;
import com.pax.market.api.sdk.java.api.goinsight.dto.DataQueryResultDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

import static com.example.paxservice.dto.PaxDataDTO.fromRowList;

@Service
@Slf4j
public class GoSignServiceImpl implements GoSignService {
    @Override
    public List<PaxDataDTO> getDataFromApi(int page) {
        TimeZone tz = TimeZone.getTimeZone("Asia/Almaty");
        GoInsightApi goInsightApi = new GoInsightApi("https://api.whatspos.com/p-market-api", "0JZJ3J7JP9AXKI3QMW1K", "WL6OXK0XT136SRNNWEIBYBR9RL6BP78KMKA2DPZX", tz);
        Result<DataQueryResultDTO> result = goInsightApi.findDataFromInsight("t3q6tkn9", GoInsightApi.TimestampRangeType.RECENT_3_HOUR, page, 500); //hzsv73by
        if (result.getBusinessCode() == 0 && result.getData().getColumns() == null
                && result.getData().getRows() == null) {
            PaxScheduleClass.currentPageOfPaxData = 1;
            log.info("Page is empty, going to first page");
        }else{
            log.error(result.getMessage());
        }
        DataQueryResultDTO data = result.getData();
        if (data == null) {
            log.info("Pax data is null");
            return new ArrayList<>();
        }
        List<List<DataQueryResultDTO.Row>> rows = data.getRows();
        return fromRowList(rows);
    }

    @Override
    public List<TerminalsInfoDTO> getAdditionalInfo(int page) {
        TimeZone tz = TimeZone.getTimeZone("Asia/Almaty");
        GoInsightApi goInsightApi = new GoInsightApi("https://api.whatspos.com/p-market-api", "0JZJ3J7JP9AXKI3QMW1K", "WL6OXK0XT136SRNNWEIBYBR9RL6BP78KMKA2DPZX", tz);
        Result<DataQueryResultDTO> result = goInsightApi.findDataFromInsight("2iax73xw", GoInsightApi.TimestampRangeType.RECENT_3_HOUR, page, 500); //hzsv73by
        if (result.getBusinessCode() == 0 && result.getData().getColumns() == null
                && result.getData().getRows() == null) {
            PaxScheduleClass.currentPageOfAdditionalInfo = 1;
            log.info("Page is empty, going to first page");
        }else{
            log.error(result.getMessage());
        }
        DataQueryResultDTO data = result.getData();
        if (data == null) {
            return new ArrayList<>();
        }
        List<List<DataQueryResultDTO.Row>> rows = data.getRows();
        return TerminalsInfoDTO.fromRowList(rows);
    }

    @Override
    public List<QuestionaryDTO> getQuestionaryInfo(int page) {
        TimeZone tz = TimeZone.getTimeZone("Asia/Almaty");
        GoInsightApi goInsightApi = new GoInsightApi("https://api.whatspos.com/p-market-api",
                "0JZJ3J7JP9AXKI3QMW1K",
                "WL6OXK0XT136SRNNWEIBYBR9RL6BP78KMKA2DPZX", tz);

        Result<DataQueryResultDTO> result = goInsightApi.findDataFromInsight("svbwvmr4",
                GoInsightApi.TimestampRangeType.RECENT_3_HOUR,
                page, 500);
        if (result.getBusinessCode() == 0 && result.getData().getColumns() == null && result.getData().getRows() == null) {
            PaxScheduleClass.currentPageOfQuestionary = 1;
            log.info("Page is empty, resetting to page 1.");
        }else{
            log.error(result.getMessage());
        }

        DataQueryResultDTO data = result.getData();

        if (data == null || data.getRows() == null || data.getRows().isEmpty()) {
            log.info("No data found on page {}. Returning empty list.", page);
            return new ArrayList<>();
        }

        List<List<DataQueryResultDTO.Row>> rows = data.getRows();
        log.info("Successfully retrieved data from page {} with {} rows.", page, rows.size());

        return QuestionaryDTO.fromRowList(rows);
    }


    @Override
    public List<CashierModeDTO> getCashierModeInfo(int page) {
        TimeZone tz = TimeZone.getTimeZone("Asia/Almaty");
        GoInsightApi goInsightApi = new GoInsightApi("https://api.whatspos.com/p-market-api",
                "0JZJ3J7JP9AXKI3QMW1K",
                "WL6OXK0XT136SRNNWEIBYBR9RL6BP78KMKA2DPZX", tz);

        Result<DataQueryResultDTO> result = goInsightApi.findDataFromInsight("2wfrd3v6",
                GoInsightApi.TimestampRangeType.RECENT_MONTH,
                page, 500);
        if (result.getBusinessCode() == 0 && result.getData().getColumns() == null && result.getData().getRows() == null) {
            PaxScheduleClass.currentPageOfCashierMode = 1;
            log.info("Page is empty, resetting to page 1.");
        }else{
            log.error(result.getMessage());
        }

        DataQueryResultDTO data = result.getData();

        if (data == null || data.getRows() == null || data.getRows().isEmpty()) {
            log.info("No data found on page {}. Returning empty list.", page);
            return new ArrayList<>();
        }

        List<List<DataQueryResultDTO.Row>> rows = data.getRows();
        log.info("Successfully retrieved data from page {} with {} rows.", page, rows.size());
        return CashierModeDTO.fromRowList(rows);
    }

    @Override
    public List<SecurityInfoDTO> getSecurityInfoByPage(int page) {
        TimeZone tz = TimeZone.getTimeZone("Asia/Almaty");
        GoInsightApi goInsightApi = new GoInsightApi("https://api.whatspos.com/p-market-api",
                "0JZJ3J7JP9AXKI3QMW1K",
                "WL6OXK0XT136SRNNWEIBYBR9RL6BP78KMKA2DPZX", tz);

        Result<DataQueryResultDTO> result = goInsightApi.findDataFromInsight("0wbxj67u",
                GoInsightApi.TimestampRangeType.RECENT_3_HOUR,
                page, 500);
        if (result.getBusinessCode() == 0 && result.getData().getColumns() == null && result.getData().getRows() == null) {
            PaxScheduleClass.currentPageOfCashierMode = 1;
            log.info("Page is empty, resetting to page 1.");
        }else{
            log.error(result.getMessage());
        }

        DataQueryResultDTO data = result.getData();

        if (data == null || data.getRows() == null || data.getRows().isEmpty()) {
            log.info("No data found on page {}. Returning empty list.", page);
            return new ArrayList<>();
        }

        List<List<DataQueryResultDTO.Row>> rows = data.getRows();
        log.info("Successfully retrieved data from page {} with {} rows.", page, rows.size());
        return SecurityInfoDTO.fromRowList(rows);
    }










    public List<QuestionaryDTO> getQuestionaryInfoByPageAndDate(int page, GoInsightApi.TimestampRangeType timestampRangeType) {
        TimeZone tz = TimeZone.getTimeZone("Asia/Almaty");
        GoInsightApi goInsightApi = new GoInsightApi("https://api.whatspos.com/p-market-api",
                "0JZJ3J7JP9AXKI3QMW1K",
                "WL6OXK0XT136SRNNWEIBYBR9RL6BP78KMKA2DPZX", tz);

        Result<DataQueryResultDTO> result = goInsightApi.findDataFromInsight("svbwvmr4",
                timestampRangeType,
                page, 500);
        if (result.getBusinessCode() == 0 && result.getData().getColumns() == null && result.getData().getRows() == null) {
            PaxScheduleClass.currentPageOfPaxData = 1;
            log.info("Page is empty, resetting to page 1.");
        }else{
            log.error(result.getMessage());
        }

        DataQueryResultDTO data = result.getData();

        if (data == null || data.getRows() == null || data.getRows().isEmpty()) {
            log.info("No data found on page {}. Returning empty list.", page);
            return new ArrayList<>();
        }

        List<List<DataQueryResultDTO.Row>> rows = data.getRows();
        log.info("Successfully retrieved data from page {} with {} rows.", page, rows.size());

        return QuestionaryDTO.fromRowList(rows);
    }


}
