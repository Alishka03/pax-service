package com.example.paxservice.repository;

import com.example.paxservice.entity.CashierMode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CashierModeRepository extends JpaRepository<CashierMode, Long> {
    Optional<CashierMode> findBySysTerminalIdAndEventTime(String sysTerminalId, String eventTime);
}

