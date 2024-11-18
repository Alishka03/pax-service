package com.example.paxservice.repository;

import com.example.paxservice.entity.PaxDataEntity;
import com.example.paxservice.entity.TerminalsInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.Optional;

public interface TerminalsInfoRepository extends JpaRepository<TerminalsInfoEntity, Long> {
    @Query("SELECT t FROM TerminalsInfoEntity t WHERE " +
            "t.sysTerminalId = :_sys_terminalid " +
            "AND t.eventTime = :_eventtime order by t.id limit 1"
    )
    Optional<TerminalsInfoEntity> getFirst(
            @Param("_sys_terminalid") String _sys_terminalid,
            @Param("_eventtime") LocalDate _eventtime);
}
