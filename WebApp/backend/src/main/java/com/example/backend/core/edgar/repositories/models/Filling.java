package com.example.backend.core.edgar.repositories.models;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Filling {
    private String cik;
    private String accessionNumber;

    // EXTENDS FIELDS TO COVER ALL THE PARANETERS

    private String filingDate;
    private String reportDate;
}
