package com.example.paxservice.repository;

import com.example.paxservice.entity.SecurityInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SecurityInfoRepository extends JpaRepository<SecurityInfo, Long> {
    Optional<SecurityInfo> findBySysTerminalIdAndEventTime(String sysTerminalId, String eventTime);
}

