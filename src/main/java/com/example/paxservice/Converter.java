package com.example.paxservice;

import com.example.paxservice.dto.PaxDataDTO;
import com.example.paxservice.dto.QuestionaryDTO;
import com.example.paxservice.dto.TerminalsInfoDTO;
import com.example.paxservice.entity.*;

import java.time.LocalDate;


public class Converter {
    public static PaxDataEntity convertFromPaxDataDto(PaxDataDTO paxDataDTO) {
        PaxDataEntity entity = new PaxDataEntity();
        entity.set_sys_terminalid(paxDataDTO.get_sys_terminalid());
        entity.setNetwork(paxDataDTO.getNetwork());
        entity.setCcid(paxDataDTO.getCcid());
        entity.setGps(paxDataDTO.getGps());
        entity.setLocation(paxDataDTO.getLocation());
        entity.setSim(paxDataDTO.getSim());
        entity.setLanguage(paxDataDTO.getLanguage());
        entity.setSimCardOne(paxDataDTO.getSimCardOne());
        entity.set_sys_marketid(paxDataDTO.get_sys_marketid());
        entity.setPrinter(paxDataDTO.getPrinter());
        entity.setBluetooth(paxDataDTO.getBluetooth());
        entity.setSimCardTwo(paxDataDTO.getSimCardTwo());
        entity.setAndroidVersion(paxDataDTO.getAndroidVersion());
        entity.set_sys_modelid(paxDataDTO.get_sys_modelid());
        entity.setMacAddress(paxDataDTO.getMacAddress());
        entity.setOfflineTime(paxDataDTO.getOfflinetime());
        entity.setSignalIntensity(paxDataDTO.getSignalIntensity());
        entity.setCpu(paxDataDTO.getCpu());
        entity.set_sys_version(paxDataDTO.get_sys_version());
        entity.setWifi(paxDataDTO.getWifi());
        entity.setBluetoothVersion(paxDataDTO.getBluetoothVersion());
        entity.setSimCardThree(paxDataDTO.getSimCardThree());
        entity.setAndroidBuild(paxDataDTO.getAndroidBuild());
        entity.setImei(paxDataDTO.getImei());
        entity.setTid(paxDataDTO.getTid());
        entity.set_sys_factoryid(paxDataDTO.get_sys_factoryid());
        entity.setSingal(paxDataDTO.getSingal());
        entity.setCALC_1000002726(paxDataDTO.getCALC_1000002726());
        entity.setModelPn(paxDataDTO.getModelPn());
        entity.setActiveTime(paxDataDTO.getActiveTime());
        entity.setPedSwitch(paxDataDTO.getPedSwitch());
        entity.setCreatedTime(paxDataDTO.getCreatedTime());
        entity.setStatus(paxDataDTO.getStatus());
        entity.setSuspendTime(paxDataDTO.getSuspendTime());
        entity.set_eventtime(paxDataDTO.get_eventtime());
        entity.setFirstActiveTime(paxDataDTO.getFirstActiveTime());
        entity.setLatestReplaceTime(paxDataDTO.getLatestReplaceTime());
        entity.set_sys_resellerid(paxDataDTO.get_sys_resellerid());
        return entity;
    }

    public static TerminalsInfoEntity convertAdditionalInfoDtoToEntity(TerminalsInfoDTO dto) {
        TerminalsInfoEntity entity = new TerminalsInfoEntity();
        entity.setPackageName(dto.getPackage_name());
        entity.setVersion(dto.getVersion());
        entity.setAppName(dto.getApp_name());
        entity.setOperator(dto.getOperator());
        entity.setSysMarketId(dto.get_sys_marketid());
        entity.setSysMerchantId(dto.get_sys_merchantid());
        entity.setSysFactoryId(dto.get_sys_factoryid());
        entity.setSysModelId(dto.get_sys_modelid());
        entity.setSysTerminalId(dto.get_sys_terminalid());
        entity.setEventTime(dto.getEvent_time()); // установка текущей даты
        return entity;
    }

    public static QuestionaryEntity convertQuestionaryDtoToEntity(QuestionaryDTO dto) {
        QuestionaryEntity entity = new QuestionaryEntity();

        entity.setSysTerminalId(dto.getSysTerminalId());
        entity.setSysResellerId(dto.getSysResellerId());
        entity.setSysMerchantId(dto.getSysMerchantId());
        entity.setPosId(dto.getPosId());
        entity.setEventTime(dto.getEventTime());
        entity.setPspVersion(dto.getPspVersion());
        entity.setEnableCashierMode(dto.getEnableCashierMode());
        entity.setQuestion1(dto.getQuestion1());
        entity.setAnswer1(dto.getAnswer1());
        entity.setQuestion2(dto.getQuestion2());
        entity.setAnswer2(dto.getAnswer2());
        entity.setQuestion3(dto.getQuestion3());
        entity.setAnswer3(dto.getAnswer3());
        entity.setQuestion4(dto.getQuestion4());
        entity.setAnswer4(dto.getAnswer4());
        entity.setQuestion5(dto.getQuestion5());
        entity.setAnswer5(dto.getAnswer5());
        entity.setQuestion6(dto.getQuestion6());
        entity.setAnswer6(dto.getAnswer6());
        entity.setQuestion7(dto.getQuestion7());
        entity.setAnswer7(dto.getAnswer7());
        entity.setQuestion8(dto.getQuestion8());
        entity.setAnswer8(dto.getAnswer8());
        entity.setQuestion9(dto.getQuestion9());
        entity.setAnswer9(dto.getAnswer9());
        entity.setQuestion10(dto.getQuestion10());
        entity.setAnswer10(dto.getAnswer10());

        return entity;
    }
}
