package com.example.backend.core.edgar.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.example.backend.core.edgar.config.EdgarEnvVariablesConfig;
import com.example.backend.core.edgar.dto.FillingResponse;
import com.example.backend.core.edgar.repositories.FillingRepository;
import com.example.backend.core.edgar.repositories.TickerRepository;

@Service
public class EdgarFillingFetchService {
    
    private final EdgarCleanService edgarCleanService;

    private final TickerRepository tickerRepository;
    private final FillingRepository fillingRepository;

    private final EdgarEnvVariablesConfig edgarEnvVariablesConfig;

    private RestClient restClient;

    public EdgarFillingFetchService(
        EdgarCleanService edgarCleanService,
        TickerRepository tickerRepository,
        FillingRepository fillingRepository,
        EdgarEnvVariablesConfig edgarEnvVariablesConfig
    ) {
        this.edgarCleanService = edgarCleanService;
        this.tickerRepository = tickerRepository;
        this.fillingRepository = fillingRepository;
        this.edgarEnvVariablesConfig = edgarEnvVariablesConfig;

        this.restClient = RestClient.builder()
            .baseUrl(edgarEnvVariablesConfig.getFillingsUrl())
            .defaultHeader("User-Agent", edgarEnvVariablesConfig.getUserAgent())
            .build();
    }


    public void fetchFilling(String ticker) {

        String cik = "";

        FillingResponse response = this.restClient
            .get()
            .uri(cik)
            .retrieve()
            .body(FillingResponse.class);

    }
}
