package com.example.backend.core.edgar;

import java.util.zip.DataFormatException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.core.edgar.services.DataCleanerService;
import com.example.backend.core.edgar.services.DataFetchServcie;

@RestController
@RequestMapping("/core/v1/edgar")
public class EdgarController {
    
    private final DataFetchServcie fDataFetchServcie;
    private final DataCleanerService fDataCleanerService;

    public EdgarController(
        DataFetchServcie dataFetchServcie,
        DataCleanerService dataCleanerService
    ) {
        this.fDataFetchServcie = dataFetchServcie;
        this.fDataCleanerService = dataCleanerService;
    }

    @GetMapping("/health")
    public ResponseEntity<String> healthCheck(){
        return ResponseEntity.ok("OK");
    }



}
