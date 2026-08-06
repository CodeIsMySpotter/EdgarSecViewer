package com.example.backend.core.edgar.services;

import org.springframework.stereotype.Service;

import com.example.backend.core.edgar.dto.FillingResponse;
import com.example.backend.core.edgar.repositories.models.Filling;

@Service
public class EdgarCleanService {
    
    public EdgarCleanService() {}

    public Filling clean(FillingResponse response) {

        Filling filling = new Filling();
        filling.setCik(response.getCik());

        // TODO: Finish the cleaning process;

        return filling;
    }
}
