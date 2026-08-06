package com.example.backend.core.edgar.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.backend.core.edgar.repositories.models.Filling;

@Repository
public interface FillingRepository extends JpaRepository<Filling, Long> {
    
    Optional<Filling> findByTickerAndCik(String ticker, String cik);
    Optional<Filling> findByTicker(String ticker);
    Optional<Filling> findByCik(String cik);
}
