package com.example.backend.core.edgar.dto;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class FillingResponse {
    String cik;
    FactsWrapper facts;
}

@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
class FactsWrapper {
    @JsonProperty("us-gaap")
    UsGaapData usGaap;
}

@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
class UsGaapData {

    @JsonProperty("Revenues")
    IndicatorData revenues;

    @JsonProperty("EarningsPerShareBasic")
    IndicatorData earningsPerShareBasic;

    @JsonProperty("EarningsPerShareDiluted")
    IndicatorData earningsPerShareDiluted;

    @JsonProperty("NetIncomeLoss")
    IndicatorData netIncomeLoss;
}

@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
class IndicatorData {
    String label;
    String description;
    Map<String, List<FactDetail>> units;
}

@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
class FactDetail {
    long val;
    int fy;
    String fp;
    String form;
    String filed;
}

