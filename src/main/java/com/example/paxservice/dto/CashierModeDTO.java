package com.example.paxservice.dto;

import com.pax.market.api.sdk.java.api.goinsight.dto.DataQueryResultDTO;
import lombok.Data;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Data
public class CashierModeDTO {
    private Long id;
    private String terminalSN;
    private String reseller;
    private String merchant;
    private String posid;
    private String pspVersion;
    private String enableCashierMode;
    private String eventTime;

    public CashierModeDTO() {
    }

    // Static method to map rows to CashierModeDTO list
    public static List<CashierModeDTO> fromRowList(List<List<DataQueryResultDTO.Row>> rowsList) {
        if (rowsList == null) {
            return new ArrayList<>();
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss XXX");
        List<CashierModeDTO> cashierModeList = new ArrayList<>();

        for (List<DataQueryResultDTO.Row> rowList : rowsList) {
            CashierModeDTO cashierModeDTO = new CashierModeDTO();

            for (DataQueryResultDTO.Row row : rowList) {
                switch (row.getColName()) {
                    case "_sys_terminalid": // Terminal SN
                        cashierModeDTO.setTerminalSN(row.getValue());
                        break;
                    case "_sys_resellerid": // Reseller
                        cashierModeDTO.setReseller(row.getValue());
                        break;
                    case "_sys_merchantid": // Merchant
                        cashierModeDTO.setMerchant(row.getValue());
                        break;
                    case "pos_id": // POSID
                        cashierModeDTO.setPosid(row.getValue());
                        break;
                    case "psp_version": // PSP Version
                        cashierModeDTO.setPspVersion(row.getValue());
                        break;
                    case "enable_cashier_mode": // Enable Cashier Mode
                        cashierModeDTO.setEnableCashierMode(row.getValue());
                        break;
                    case "_eventtime": // Event Time
                        cashierModeDTO.setEventTime(row.getValue());
                        break;
                    default:
                        // Handle unexpected column names if needed
                        break;
                }
            }

            cashierModeList.add(cashierModeDTO);
        }

        return cashierModeList;
    }
}
