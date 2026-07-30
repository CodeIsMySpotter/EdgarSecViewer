package com.example.backend.edgar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.backend.core.edgar.EdgarController;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest

public class EdgarIntegrationTests {


    @Autowired
    private EdgarController edgarController;

    private MockMvc mockMvc;


    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(edgarController).build();
    }


    @Test
    void healthCheck() throws Exception{
        mockMvc.perform(get("/core/v1/edgar/health"))
            .andExpect(status().isOk())
            .andExpect(content().string("OK"));
    }


    @Test
    void getTickerList() throws Exception{
        mockMvc.perform(get("/core/v1/edgar/tickerList"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$").isArray())
            .andExpect(jsonPath("$").isNotEmpty());
    }
}
