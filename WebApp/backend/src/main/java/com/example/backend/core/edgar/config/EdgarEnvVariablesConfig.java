package com.example.backend.core.edgar.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "edgar.api")
public class EdgarEnvVariablesConfig {
    
    private String baseUrl; 
    private String userAgent;
    private String tickersFile;
    private String fillingsUrl;

    public String getTickersFile() {
        return tickersFile;
    }

    public void setTickersFile(String tickersFile) {
        this.tickersFile = tickersFile;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }


    public void setFillingsUrl(String fillingsUrl) {
        this.fillingsUrl = fillingsUrl;
    }

    public String getFillingsUrl() {
        return fillingsUrl;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }
}
