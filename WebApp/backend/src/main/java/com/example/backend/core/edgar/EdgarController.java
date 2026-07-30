package com.example.backend.core.edgar;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.core.edgar.repositories.models.Ticker;
import com.example.backend.core.edgar.services.EdgarCleanService;
import com.example.backend.core.edgar.services.EdgarFillingFetchService;
import com.example.backend.core.edgar.services.EdgarTickerFetchServcie;

@RestController
@RequestMapping("/core/v1/edgar")
public class EdgarController {
    
    private final EdgarTickerFetchServcie edgarTickerFetchServcie;
    private final EdgarFillingFetchService edgarFillingFetchService;
    private final EdgarCleanService edgarCleanService;

    public EdgarController(
        EdgarTickerFetchServcie edgarTickerFetchServcie,
        EdgarFillingFetchService edgarFillingFetchService,
        EdgarCleanService edgarCleanService
    ) {
        this.edgarTickerFetchServcie = edgarTickerFetchServcie;
        this.edgarFillingFetchService = edgarFillingFetchService;
        this.edgarCleanService = edgarCleanService;
    }

    @GetMapping("/health")
    public ResponseEntity<String> healthCheck(){
        return ResponseEntity.ok("OK");
    }

    @GetMapping("/tickerList")
    public ResponseEntity<List<Ticker>> getTickerList(){
        List<Ticker> result = edgarTickerFetchServcie.getAllTickers();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/fillings/fetch")
    public ResponseEntity<String> fetchFilling() {
        return ResponseEntity.ok("OK");
    } 



}
