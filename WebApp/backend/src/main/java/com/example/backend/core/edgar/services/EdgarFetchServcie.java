package com.example.backend.core.edgar.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.backend.core.edgar.config.EdgarEnvVariablesConfig;
import com.example.backend.core.edgar.repositories.TickerRepository;
import com.example.backend.core.edgar.repositories.models.Ticker;


@Service
public class EdgarFetchServcie {

    private final EdgarEnvVariablesConfig edgarEnvVariablesConfig;
    private final TickerRepository tickerRepository;
    
    public EdgarFetchServcie(
        EdgarEnvVariablesConfig edgarEnvVariablesConfig,
        TickerRepository tickerRepository
    ) {
        this.edgarEnvVariablesConfig = edgarEnvVariablesConfig;
        this.tickerRepository = tickerRepository;
    }

    public List<String> getAllTickers() {
        return tickerRepository.findAll().stream()
                .map(Ticker::getTicker)
                .toList();
    }
 }
