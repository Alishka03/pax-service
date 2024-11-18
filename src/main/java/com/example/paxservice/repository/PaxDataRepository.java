package com.example.paxservice.repository;

import com.example.paxservice.entity.PaxDataEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PaxDataRepository extends JpaRepository<PaxDataEntity, Long> {
    @Query("SELECT p FROM PaxDataEntity p WHERE " +
            "p._sys_terminalid = :_sys_terminalid " +
            "AND p._eventtime = :_eventtime order by p.id limit 1"
    )
    Optional<PaxDataEntity> getFirst(
            @Param("_sys_terminalid") String _sys_terminalid,
            @Param("_eventtime") String _eventtime);
}
