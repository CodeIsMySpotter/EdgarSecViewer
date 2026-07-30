package com.example.backend.core.edgar.services;

import org.springframework.stereotype.Service;

import com.example.backend.core.edgar.config.EdgarEnvVariablesConfig;


@Service
public class EdgarFetchServcie {

    private final EdgarEnvVariablesConfig edgarEnvVariablesConfig;
    
    public EdgarFetchServcie(
        EdgarEnvVariablesConfig edgarEnvVariablesConfig
    ) {
        this.edgarEnvVariablesConfig = edgarEnvVariablesConfig;
    }
}
