package com.example.paxservice.entity;
import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Entity
@Table(name = "pax_data")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
//@EqualsAndHashCode
public class PaxDataEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "_sys_terminalid")
    private String _sys_terminalid;

    @Column(name = "network")
    private String network;

    @Column(name = "ccid")
    private String ccid;

    @Column(name = "gps")
    private String gps;

    @Column(name = "location")
    private String location;

    @Column(name = "sim")
    private String sim;

    @Column(name = "language")
    private String language;

    @Column(name = "sim_card_one")
    private String simCardOne;

    @Column(name = "_sys_marketid")
    private String _sys_marketid;

    @Column(name = "printer")
    private String printer;

    @Column(name = "bluetooth")
    private String bluetooth;

    @Column(name = "sim_card_two")
    private String simCardTwo;

    @Column(name = "android_version")
    private String androidVersion;

    @Column(name = "_sys_modelid")
    private String _sys_modelid;

    @Column(name = "mac_address")
    private String macAddress;

    @Column(name = "offline_time")
    private String offlineTime;

    @Column(name = "signal_intensity")
    private String signalIntensity;

    @Column(name = "cpu")
    private String cpu;

    @Column(name = "_sys_version")
    private String _sys_version;

    @Column(name = "wifi")
    private String wifi;

    @Column(name = "bluetooth_version")
    private String bluetoothVersion;

    @Column(name = "sim_card_three")
    private String simCardThree;

    @Column(name = "android_build")
    private String androidBuild;

    // Дополнительные поля
    @Column(name = "imei")
    private String imei;

    @Column(name = "tid")
    private String tid;

    @Column(name = "_sys_factoryid")
    private String _sys_factoryid;

    @Column(name = "signal")
    private String singal;

    @Column(name = "CALC_1000002726")
    private String CALC_1000002726;

    @Column(name = "modelPn")
    private String modelPn;

    @Column(name = "activeTime")
    private String activeTime;

    @Column(name = "pedSwitch")
    private String pedSwitch;

    @Column(name = "createdTime")
    private String createdTime;

    @Column(name = "status")
    private String status;

    @Column(name = "suspendTime")
    private String suspendTime;

    @Column(name = "_eventtime")
    private String _eventtime;

    @Column(name = "firstActiveTime")
    private String firstActiveTime;

    @Column(name = "latestReplaceTime")
    private String latestReplaceTime;

    @Column(name = "_sys_resellerid")
    private String _sys_resellerid;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaxDataEntity that = (PaxDataEntity) o;
        return Objects.equals(_sys_terminalid, that._sys_terminalid) && Objects.equals(network, that.network) && Objects.equals(ccid, that.ccid) && Objects.equals(gps, that.gps) && Objects.equals(location, that.location) && Objects.equals(sim, that.sim) && Objects.equals(language, that.language) && Objects.equals(simCardOne, that.simCardOne) && Objects.equals(_sys_marketid, that._sys_marketid) && Objects.equals(printer, that.printer) && Objects.equals(bluetooth, that.bluetooth) && Objects.equals(simCardTwo, that.simCardTwo) && Objects.equals(androidVersion, that.androidVersion) && Objects.equals(_sys_modelid, that._sys_modelid) && Objects.equals(macAddress, that.macAddress) && Objects.equals(offlineTime, that.offlineTime) && Objects.equals(signalIntensity, that.signalIntensity) && Objects.equals(cpu, that.cpu) && Objects.equals(_sys_version, that._sys_version) && Objects.equals(wifi, that.wifi) && Objects.equals(bluetoothVersion, that.bluetoothVersion) && Objects.equals(simCardThree, that.simCardThree) && Objects.equals(androidBuild, that.androidBuild) && Objects.equals(imei, that.imei) && Objects.equals(tid, that.tid) && Objects.equals(_sys_factoryid, that._sys_factoryid) && Objects.equals(singal, that.singal) && Objects.equals(CALC_1000002726, that.CALC_1000002726) && Objects.equals(modelPn, that.modelPn) && Objects.equals(activeTime, that.activeTime) && Objects.equals(pedSwitch, that.pedSwitch) && Objects.equals(createdTime, that.createdTime) && Objects.equals(status, that.status) && Objects.equals(suspendTime, that.suspendTime) && Objects.equals(_eventtime, that._eventtime) && Objects.equals(firstActiveTime, that.firstActiveTime) && Objects.equals(latestReplaceTime, that.latestReplaceTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_sys_terminalid, network, ccid, gps, location, sim, language, simCardOne, _sys_marketid, printer, bluetooth, simCardTwo, androidVersion, _sys_modelid, macAddress, offlineTime, signalIntensity, cpu, _sys_version, wifi, bluetoothVersion, simCardThree, androidBuild, imei, tid, _sys_factoryid, singal, CALC_1000002726, modelPn, activeTime, pedSwitch, createdTime, status, suspendTime, _eventtime, firstActiveTime, latestReplaceTime);
    }
}

