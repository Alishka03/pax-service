package com.example.paxservice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "cashier_mode")
@Getter
@Setter
public class CashierMode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "_sys_terminalid")
    private String sysTerminalId;  // Terminal SN

    @Column(name = "_sys_resellerid")
    private String sysResellerId;  // Reseller

    @Column(name = "_sys_merchantid")
    private String sysMerchantId;  // Merchant

    @Column(name = "pos_id")
    private String posId;          // POSID

    @Column(name = "psp_version")
    private String pspVersion;     // PSP Version

    @Column(name = "enable_cashier_mode")
    private String enableCashierMode; // Enable Cashier Mode

    @Column(name = "_eventtime")
    private String eventTime;      // Event Time
}
