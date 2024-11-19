package com.example.paxservice.dto;

import com.pax.market.api.sdk.java.api.goinsight.dto.DataQueryResultDTO;
import lombok.Data;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Data
public class QuestionaryDTO {

    private String sysTerminalId;
    private String sysResellerId;
    private String sysMerchantId;
    private ZonedDateTime eventTime;
    private String posId;
    private String pspVersion;
    private String enableCashierMode;
    private String question1;
    private String answer1;
    private String question2;
    private String answer2;
    private String question3;
    private String answer3;
    private String question4;
    private String answer4;
    private String question5;
    private String answer5;
    private String question6;
    private String answer6;
    private String question7;
    private String answer7;
    private String question8;
    private String answer8;
    private String question9;
    private String answer9;
    private String question10;
    private String answer10;

    public QuestionaryDTO() {
    }

    public static List<QuestionaryDTO> fromRowList(List<List<DataQueryResultDTO.Row>> rowsList) {
        if (rowsList == null) {
            return new ArrayList<>();
        }

        List<QuestionaryDTO> questionaryList = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss XXX");

        for (List<DataQueryResultDTO.Row> rowList : rowsList) {
            QuestionaryDTO questionaryDTO = new QuestionaryDTO();
            for (DataQueryResultDTO.Row row : rowList) {
                switch (row.getColName()) {
                    case "_sys_terminalid":
                        questionaryDTO.setSysTerminalId(row.getValue());
                        break;
                    case "_sys_resellerid":
                        questionaryDTO.setSysResellerId(row.getValue());
                        break;
                    case "_sys_merchantid":
                        questionaryDTO.setSysMerchantId(row.getValue());
                        break;
                    case "pos_id":
                        questionaryDTO.setPosId(row.getValue());
                        break;
                    case "psp_version":
                        questionaryDTO.setPspVersion(row.getValue());
                        break;
                    case "enable_cashier_mode":
                        questionaryDTO.setEnableCashierMode(row.getValue());
                        break;
                    case "question1":
                        questionaryDTO.setQuestion1(row.getValue());
                        break;
                    case "answer1":
                        questionaryDTO.setAnswer1(row.getValue());
                        break;
                    case "question2":
                        questionaryDTO.setQuestion2(row.getValue());
                        break;
                    case "answer2":
                        questionaryDTO.setAnswer2(row.getValue());
                        break;
                    case "question3":
                        questionaryDTO.setQuestion3(row.getValue());
                        break;
                    case "answer3":
                        questionaryDTO.setAnswer3(row.getValue());
                        break;
                    case "question4":
                        questionaryDTO.setQuestion4(row.getValue());
                        break;
                    case "answer4":
                        questionaryDTO.setAnswer4(row.getValue());
                        break;
                    case "question5":
                        questionaryDTO.setQuestion5(row.getValue());
                        break;
                    case "answer5":
                        questionaryDTO.setAnswer5(row.getValue());
                        break;
                    case "question6":
                        questionaryDTO.setQuestion6(row.getValue());
                        break;
                    case "answer6":
                        questionaryDTO.setAnswer6(row.getValue());
                        break;
                    case "question7":
                        questionaryDTO.setQuestion7(row.getValue());
                        break;
                    case "answer7":
                        questionaryDTO.setAnswer7(row.getValue());
                        break;
                    case "question8":
                        questionaryDTO.setQuestion8(row.getValue());
                        break;
                    case "answer8":
                        questionaryDTO.setAnswer8(row.getValue());
                        break;
                    case "question9":
                        questionaryDTO.setQuestion9(row.getValue());
                        break;
                    case "answer9":
                        questionaryDTO.setAnswer9(row.getValue());
                        break;
                    case "question10":
                        questionaryDTO.setQuestion10(row.getValue());
                        break;
                    case "answer10":
                        questionaryDTO.setAnswer10(row.getValue());
                        break;
                    case "_eventtime":
                        if (row.getValue() != null) {
                            ZonedDateTime parsedEventTime = ZonedDateTime.parse(row.getValue(), formatter);
                            ZonedDateTime almatyTime = parsedEventTime.withZoneSameInstant(ZoneId.of("Asia/Almaty"));
                            ZonedDateTime adjustedTime = almatyTime.minusHours(1);
                            questionaryDTO.setEventTime(adjustedTime);
                        }
                        break;
                    default:
                        // Optionally log or handle unknown column names
                        break;
                }
            }

            questionaryList.add(questionaryDTO);
        }

        return questionaryList;
    }


}
