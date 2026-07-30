package com.example.backend.core.edgar.repositories;

import com.example.backend.core.edgar.repositories.models.Ticker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface TickerRepository extends JpaRepository<Ticker, Long> {
    
    Optional<Ticker> findByTicker(String ticker);
    
    Optional<Ticker> findByCik(String cik);
}
