package com.example.paxservice.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "security_info", uniqueConstraints = @UniqueConstraint(columnNames = {"_sys_terminalid", "_eventtime"}))
@Getter
@Setter
public class SecurityInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "_sys_terminalid", nullable = false)
    private String sysTerminalId;

    @Column(name = "acquirer_terminal_id")
    private String acquirerTerminalId;

    @Column(name = "_sys_resellerid")
    private String sysResellerId;

    @Column(name = "_sys_merchantid")
    private String sysMerchantId;

    @Column(name = "acquirer_name")
    private String acquirerName;

    @Column(name = "halyk_qr_point_of_sale")
    private String halykQrPointOfSale;

    @Column(name = "enable_t7s")
    private String enableT7s;

    @Column(name = "edc_ped_mode")
    private String edcPedMode;

    @Column(name = "gocard_merchant_id")
    private String gocardMerchantId;

    @Column(name = "receipt_check_title")
    private String receiptCheckTitle;

    @Column(name = "settings_admin_common_license")
    private String settingsAdminCommonLicense;

    @Column(name = "gocard_terminal_id")
    private String gocardTerminalId;

    @Column(name = "receipt_check_title2")
    private String receiptCheckTitle2;

    @Column(name = "acquirer_terminal_id2")
    private String acquirerTerminalId2;

    @Column(name = "acquirer_name2")
    private String acquirerName2;

    @Column(name = "gocard_terminal_id2")
    private String gocardTerminalId2;

    @Column(name = "_eventtime")
    private String eventTime;
}

