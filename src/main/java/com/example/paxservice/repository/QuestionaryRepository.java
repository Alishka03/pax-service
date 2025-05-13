package com.example.paxservice.repository;

import com.example.paxservice.entity.QuestionaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.ZonedDateTime;
import java.util.Optional;

@Repository
public interface QuestionaryRepository extends JpaRepository<QuestionaryEntity, Long> {
    @Query("SELECT q FROM QuestionaryEntity q WHERE " +
            "q.sysTerminalId = :_sys_terminalid " +
            "AND q.eventTime = :_eventtime order by q.id")
    Optional<QuestionaryEntity> getFirst(
            @Param("_sys_terminalid") String _sys_terminalid,
            @Param("_eventtime") ZonedDateTime _eventtime);


    @Query("SELECT q FROM QuestionaryEntity q WHERE " +
            "q.sysTerminalId = :_sys_terminalid " +
            "AND q.eventTime = :_eventtime " +
            "AND q.acquirerTerminalId IS NULL " +
            "ORDER BY q.id")
    Optional<QuestionaryEntity> getQuestionaryEntitiesBySysTerminalIdAndEventTime(
            @Param("_sys_terminalid") String _sys_terminalid,
            @Param("_eventtime") ZonedDateTime _eventtime);

}
