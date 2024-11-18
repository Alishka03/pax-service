
package com.example.paxservice.dto;


import com.pax.market.api.sdk.java.api.goinsight.dto.DataQueryResultDTO;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
@Data
public class PaxDataDTO {
    private String _sys_terminalid;
    private String network;
    private String ccid;
    private String gps;
    private String location;
    private String sim;
    private String language;
    private String simCardOne;
    private String _sys_marketid;
    private String printer;
    private String bluetooth;
    private String simCardTwo;
    private String androidVersion;
    private String _sys_modelid;
    private String macAddress;
    private String offlinetime;
    private String signalIntensity;
    private String cpu;
    private String _sys_version;
    private String wifi;
    private String bluetoothVersion;
    private String simCardThree;
    private String androidBuild;


    // Дополнительные поля
    private String imei;
    private String tid;
    private String _sys_factoryid;
    private String singal;
    private String CALC_1000002726;
    private String modelPn;
    private String activeTime;
    private String pedSwitch;
    private String createdTime;
    private String status;
    private String suspendTime;
    private String _eventtime;
    private String firstActiveTime;
    private String latestReplaceTime;
    private String _sys_resellerid;

    public PaxDataDTO() {
    }

    public static List<PaxDataDTO> fromRowList(List<List<DataQueryResultDTO.Row>> rowsList) {
        List<PaxDataDTO> paxDataList = new ArrayList<>();

        for (List<DataQueryResultDTO.Row> rowList : rowsList) {
            PaxDataDTO paxDataDTO = new PaxDataDTO();

            for (DataQueryResultDTO.Row row : rowList) {
                switch (row.getColName()) {
                    case "_sys_terminalid":
                        paxDataDTO.set_sys_terminalid(row.getValue());
                        break;
                    case "network":
                        paxDataDTO.setNetwork(row.getValue());
                        break;
                    case "ccid":
                        paxDataDTO.setCcid(row.getValue());
                        break;
                    case "gps":
                        paxDataDTO.setGps(row.getValue());
                        break;
                    case "location":
                        paxDataDTO.setLocation(row.getValue());
                        break;
                    case "sim":
                        paxDataDTO.setSim(row.getValue());
                        break;
                    case "language":
                        paxDataDTO.setLanguage(row.getValue());
                        break;
                    case "simCardOne":
                        paxDataDTO.setSimCardOne(row.getValue());
                        break;
                    case "_sys_marketid":
                        paxDataDTO.set_sys_marketid(row.getValue());
                        break;
                    case "printer":
                        paxDataDTO.setPrinter(row.getValue());
                        break;
                    case "bluetooth":
                        paxDataDTO.setBluetooth(row.getValue());
                        break;
                    case "simCardTwo":
                        paxDataDTO.setSimCardTwo(row.getValue());
                        break;
                    case "androidVersion":
                        paxDataDTO.setAndroidVersion(row.getValue());
                        break;
                    case "_sys_modelid":
                        paxDataDTO.set_sys_modelid(row.getValue());
                        break;
                    case "macAddress":
                        paxDataDTO.setMacAddress(row.getValue());
                        break;
                    case "signalIntensity":
                        paxDataDTO.setSignalIntensity(row.getValue());
                        break;
                    case "cpu":
                        paxDataDTO.setCpu(row.getValue());
                        break;
                    // ???????? ????????? ???? ??????????? ???????
                    case "imei":
                        paxDataDTO.setImei(row.getValue());
                        break;
                    case "tid":
                        paxDataDTO.setTid(row.getValue());
                        break;
                    case "_sys_factoryid":
                        paxDataDTO.set_sys_factoryid(row.getValue());
                        break;
                    case "singal":
                        paxDataDTO.setSingal(row.getValue());
                        break;
                    case "CALC_1000002726":
                        paxDataDTO.setCALC_1000002726(row.getValue());
                        break;
                    case "modelPn":
                        paxDataDTO.setModelPn(row.getValue());
                        break;
                    case "activeTime":
                        paxDataDTO.setActiveTime(row.getValue());
                        break;
                    case "pedSwitch":
                        paxDataDTO.setPedSwitch(row.getValue());
                        break;
                    case "createdTime":
                        paxDataDTO.setCreatedTime(row.getValue());
                        break;
                    case "status":
                        paxDataDTO.setStatus(row.getValue());
                        break;
                    case "suspendTime":
                        paxDataDTO.setSuspendTime(row.getValue());
                        break;
                    case "_eventtime":
                        paxDataDTO.set_eventtime(row.getValue());
                        break;
                    case "firstActiveTime":
                        paxDataDTO.setFirstActiveTime(row.getValue());
                        break;
                    case "latestReplaceTime":
                        paxDataDTO.setLatestReplaceTime(row.getValue());
                        break;
                    case "_sys_resellerid":
                        paxDataDTO.set_sys_resellerid(row.getValue());
                        break;

                    //
                }
            }

            paxDataList.add(paxDataDTO);
        }

        return paxDataList;
    }
}


//{_sys_terminalid=2820045630}
//        {network=Wi-Fi}
//        {ccid=89997079000041456747}
//        {gps=Enabled}
//        {location=42.900520,71.378330}
//        {sim=Enabled}
//        {language=русский}
//        {simCardOne=ALTEL 4G}
//        {_sys_marketid=Halyk Bank Global}
//        {printer=Available}
//        {bluetooth=Enabled}
//        {simCardTwo=-}
//        {androidVersion=10}
//        {_sys_modelid=A930}
//        {macAddress=0E:0F:DF:45:0F:42}
//        {offlinetime=1 Day}
//        {signalIntensity=null}
//        {cpu=null}