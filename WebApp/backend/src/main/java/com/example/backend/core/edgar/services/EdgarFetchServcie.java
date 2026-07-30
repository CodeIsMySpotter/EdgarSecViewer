package com.example.backend.core.edgar.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.example.backend.core.edgar.config.EdgarEnvVariablesConfig;
import com.example.backend.core.edgar.repositories.TickerRepository;
import com.example.backend.core.edgar.repositories.models.Ticker;

@Service
public class EdgarFetchServcie {

    private final EdgarEnvVariablesConfig edgarEnvVariablesConfig;
    private final TickerRepository tickerRepository;

    private RestClient restClient;

    public EdgarFetchServcie(
            EdgarEnvVariablesConfig edgarEnvVariablesConfig,
            TickerRepository tickerRepository) {
        this.edgarEnvVariablesConfig = edgarEnvVariablesConfig;
        this.tickerRepository = tickerRepository;

        this.restClient = RestClient.builder()
            .baseUrl(edgarEnvVariablesConfig.getBaseUrl())
            .defaultHeader("User-Agent", edgarEnvVariablesConfig.getUserAgent())
            .build();
    }

    public List<Ticker> getAllTickers() {
        
        List<Ticker> result;

        if (tickerRepository.count() == 0) {
            result = fetchTickers();
            return result;
        }

        result = tickerRepository.findAll();
        return result;
    }

    public List<Ticker> fetchTickers() {

        String file = this.edgarEnvVariablesConfig.getTickersFile();
        Map<String, Ticker> response = this.restClient
            .get()
            .uri(file)
            .retrieve()
            .body(new ParameterizedTypeReference<Map<String, Ticker>>() {});
        
        
        List<Ticker> tickers = new ArrayList<Ticker>(response.values());

        tickerRepository.saveAll(tickers);
        return tickers;
    }
}
