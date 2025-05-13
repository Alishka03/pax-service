package com.example.paxservice.dto;

import com.pax.market.api.sdk.java.api.goinsight.dto.DataQueryResultDTO;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class SecurityInfoDTO {
    private String _sys_terminalid;
    private String acquirerTerminalId;
    private String _sys_resellerid;
    private String _sys_merchantid;
    private String acquirerName;
    private String halykQrPointOfSale;
    private String enableT7s;
    private String edcPedMode;
    private String gocardMerchantId;
    private String receiptCheckTitle;
    private String settingsAdminCommonLicense;
    private String gocardTerminalId;
    private String receiptCheckTitle2;
    private String acquirerTerminalId2;
    private String acquirerName2;
    private String gocardTerminalId2;
    private String _eventtime;


    public static List<SecurityInfoDTO> fromRowList(List<List<DataQueryResultDTO.Row>> rowsList) {
        if (rowsList == null || rowsList.isEmpty()) {
            return new ArrayList<>();
        }

        List<SecurityInfoDTO> securityInfoList = new ArrayList<>();

        for (List<DataQueryResultDTO.Row> rowList : rowsList) {
            SecurityInfoDTO dto = new SecurityInfoDTO();

            for (DataQueryResultDTO.Row row : rowList) {
                switch (row.getColName()) {
                    case "_sys_terminalid":
                        dto.set_sys_terminalid(row.getValue());
                        break;
                    case "acquirer_terminal_id":
                        dto.setAcquirerTerminalId(row.getValue());
                        break;
                    case "_sys_resellerid":
                        dto.set_sys_resellerid(row.getValue());
                        break;
                    case "_sys_merchantid":
                        dto.set_sys_merchantid(row.getValue());
                        break;
                    case "acquirer_name":
                        dto.setAcquirerName(row.getValue());
                        break;
                    case "halyk_qr_point_of_sale":
                        dto.setHalykQrPointOfSale(row.getValue());
                        break;
                    case "enable_t7s":
                        dto.setEnableT7s(row.getValue());
                        break;
                    case "edc_ped_mode":
                        dto.setEdcPedMode(row.getValue());
                        break;
                    case "gocard_merchant_id":
                        dto.setGocardMerchantId(row.getValue());
                        break;
                    case "receipt_check_title":
                        dto.setReceiptCheckTitle(row.getValue());
                        break;
                    case "settings_admin_common_license":
                        dto.setSettingsAdminCommonLicense(row.getValue());
                        break;
                    case "gocard_terminal_id":
                        dto.setGocardTerminalId(row.getValue());
                        break;
                    case "receipt_check_title2":
                        dto.setReceiptCheckTitle2(row.getValue());
                        break;
                    case "acquirer_terminal_id2":
                        dto.setAcquirerTerminalId2(row.getValue());
                        break;
                    case "acquirer_name2":
                        dto.setAcquirerName2(row.getValue());
                        break;
                    case "gocard_terminal_id2":
                        dto.setGocardTerminalId2(row.getValue());
                        break;
                    case "_eventtime":
                        dto.set_eventtime(row.getValue());
                        break;
                }
            }

            securityInfoList.add(dto);
        }

        return securityInfoList;
    }
}
