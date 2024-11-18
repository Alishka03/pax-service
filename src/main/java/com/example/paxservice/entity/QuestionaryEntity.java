package com.example.paxservice.entity;
import jakarta.persistence.*;
import lombok.*;

import jakarta.persistence.Column;

import java.time.ZonedDateTime;

@Data
@Entity
@Table(name = "questionary")
public class QuestionaryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "_sys_terminalid")
    private String sysTerminalId;

    @Column(name = "_sys_resellerid")
    private String sysResellerId;

    @Column(name = "_sys_merchantid")
    private String sysMerchantId;

    @Column(name = "_eventtime")
    private ZonedDateTime eventTime;

    @Column(name = "pos_id")
    private String posId;

    @Column(name = "psp_version")
    private String pspVersion;

    @Column(name = "enable_cashier_mode")
    private String enableCashierMode;

    @Column(name = "question1")
    private String question1;

    @Column(name = "answer1")
    private String answer1;

    @Column(name = "question2")
    private String question2;

    @Column(name = "answer2")
    private String answer2;

    @Column(name = "question3")
    private String question3;

    @Column(name = "answer3")
    private String answer3;

    @Column(name = "question4")
    private String question4;

    @Column(name = "answer4")
    private String answer4;

    @Column(name = "question5")
    private String question5;

    @Column(name = "answer5")
    private String answer5;

    @Column(name = "question6")
    private String question6;

    @Column(name = "answer6")
    private String answer6;

    @Column(name = "question7")
    private String question7;

    @Column(name = "answer7")
    private String answer7;

    @Column(name = "question8")
    private String question8;

    @Column(name = "answer8")
    private String answer8;

    @Column(name = "question9")
    private String question9;

    @Column(name = "answer9")
    private String answer9;

    @Column(name = "question10")
    private String question10;

    @Column(name = "answer10")
    private String answer10;
}
//THIS IS NEW ENTITY
//BUT THEY ARE ASKING ME CREATE another new ENTITY
//ENTITY [SET_HERE_NAME_BY_YOURSELF]
//systerminal_id PRIMARY KEY
//pos_id PRIMARY KEY
//event_time
//questionary_composite
