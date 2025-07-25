package com.dstefanelli.springbootdemo.infrastructure.client;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class CampaignResponse {
    private String game;
    @Getter
    private String name;
    private Double priority;
    private Boolean enabled;
    @Getter
    private CampaignMatchers matchers;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private LocalDateTime lastUpdated;
}
