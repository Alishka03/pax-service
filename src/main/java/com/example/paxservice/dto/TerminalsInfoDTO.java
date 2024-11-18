package com.example.paxservice.dto;

import com.pax.market.api.sdk.java.api.goinsight.dto.DataQueryResultDTO;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class TerminalsInfoDTO {
    private String package_name; //
    private String version; //
    private String app_name; //
    private String operator; //
    private String _sys_marketid; //
    private String _sys_merchantid; //
    private String _sys_factoryid; //
    private String _sys_modelid; //
    private String _sys_terminalid;
    private LocalDate event_time;

    TerminalsInfoDTO(){

    }
    public static List<TerminalsInfoDTO> fromRowList(List<List<DataQueryResultDTO.Row>> rowsList) {
        List<TerminalsInfoDTO> terminalsInfoDTOS = new ArrayList<>();

        for (List<DataQueryResultDTO.Row> rowList : rowsList) {
            TerminalsInfoDTO terminalsInfoDTO = new TerminalsInfoDTO();

            for (DataQueryResultDTO.Row row : rowList) {
                switch (row.getColName()) {
                    case "package_name":
                        terminalsInfoDTO.setPackage_name(row.getValue());
                        break;
                    case "version":
                        terminalsInfoDTO.setVersion(row.getValue());
                        break;
                    case "app_name":
                        terminalsInfoDTO.setApp_name(row.getValue());
                        break;
                    case "operator":
                        terminalsInfoDTO.setOperator(row.getValue());
                        break;
                    case "_sys_marketid":
                        terminalsInfoDTO.set_sys_marketid(row.getValue());
                        break;
                    case "_sys_merchantid":
                        terminalsInfoDTO.set_sys_merchantid(row.getValue());
                        break;

                    case "_sys_modelid":
                        terminalsInfoDTO.set_sys_modelid(row.getValue());
                        break;

                    case "_sys_factoryid":
                        terminalsInfoDTO.set_sys_factoryid(row.getValue());
                        break;
                    case "_sys_terminalid":
                        terminalsInfoDTO.set_sys_terminalid(row.getValue());
                        break;
                    //
                }
                terminalsInfoDTO.setEvent_time(LocalDate.now());
            }
            terminalsInfoDTOS.add(terminalsInfoDTO);
        }

        return terminalsInfoDTOS;
    }
}
