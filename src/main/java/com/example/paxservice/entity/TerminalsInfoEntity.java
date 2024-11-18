package com.example.paxservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "terminals_additional_info")
public class TerminalsInfoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "package_name")
    private String packageName;

    @Column(name = "version")
    private String version;

    @Column(name = "app_name")
    private String appName;

    @Column(name = "operator")
    private String operator;

    @Column(name = "_sys_marketid")
    private String sysMarketId;

    @Column(name = "_sys_merchantid")
    private String sysMerchantId;

    @Column(name = "_sys_factoryid")
    private String sysFactoryId;

    @Column(name = "_sys_modelid")
    private String sysModelId;

    @Column(name = "_sys_terminalid")
    private String sysTerminalId;

    @Column(name = "event_time")
    private LocalDate eventTime;
}
