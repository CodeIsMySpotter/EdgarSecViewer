package com.example.backend.core.edgar;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.core.edgar.repositories.models.Ticker;
import com.example.backend.core.edgar.services.EdgarCleanService;
import com.example.backend.core.edgar.services.EdgarFetchServcie;

@RestController
@RequestMapping("/core/v1/edgar")
public class EdgarController {
    
    private final EdgarFetchServcie fDataFetchServcie;
    private final EdgarCleanService fDataCleanerService;

    public EdgarController(
        EdgarFetchServcie dataFetchServcie,
        EdgarCleanService dataCleanerService
    ) {
        this.fDataFetchServcie = dataFetchServcie;
        this.fDataCleanerService = dataCleanerService;
    }

    @GetMapping("/health")
    public ResponseEntity<String> healthCheck(){
        return ResponseEntity.ok("OK");
    }

    @GetMapping("/tickerList")
    public ResponseEntity<List<Ticker>> getTickerList(){
        List<Ticker> result = fDataFetchServcie.getAllTickers();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/fillings/fetch")
    public ResponseEntity<String> fetchFilling() {
        return ResponseEntity.ok("OK");
    } 



}
