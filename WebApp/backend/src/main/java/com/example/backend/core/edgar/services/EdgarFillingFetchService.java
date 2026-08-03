package com.example.backend.core.edgar.services;

import org.springframework.stereotype.Service;

@Service
public class EdgarFillingFetchService {
    
    private final EdgarCleanService edgarCleanService;

    public EdgarFillingFetchService(
        EdgarCleanService edgarCleanService
    ) {
        this.edgarCleanService = edgarCleanService;
    }


    public void fetchFilling(String cik) {
        
    }
}
