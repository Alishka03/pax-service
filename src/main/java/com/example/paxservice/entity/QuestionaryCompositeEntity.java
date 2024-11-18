package com.example.paxservice.entity;

import com.example.paxservice.entity.embeddable.QuestionaryId;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;

import java.time.ZonedDateTime;

@Entity
@Getter
@Table(name = "questionary_composite")
public class QuestionaryCompositeEntity {
    @EmbeddedId
    private QuestionaryId id;

    @Column(name = "event_time")
    private ZonedDateTime eventTime;

    public QuestionaryCompositeEntity(QuestionaryId id, ZonedDateTime eventTime) {
        this.id = id;
        this.eventTime = eventTime;
    }

    public void setEventTime(ZonedDateTime eventTime) {
        this.eventTime = eventTime;
    }

    public QuestionaryCompositeEntity() {
    }
}
