package com.example.paxservice.entity.embeddable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
public class QuestionaryId {

    @Column(name = "_sys_terminalid")
    private String sysTerminalId;

    @Column(name = "pos_id")
    private String posId;

    public QuestionaryId(String sysTerminalId, String posId) {
        this.sysTerminalId = sysTerminalId;
        this.posId = posId;
    }
}
