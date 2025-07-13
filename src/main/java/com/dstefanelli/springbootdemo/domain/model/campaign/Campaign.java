package com.dstefanelli.springbootdemo.domain.model.campaign;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
public class Campaign {
    private String game;
    @Getter
    private String name;
    private Double priority;
    private Boolean enabled;
    @Getter
    private List<Matcher> matchers;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private LocalDateTime lastUpdated;
}
