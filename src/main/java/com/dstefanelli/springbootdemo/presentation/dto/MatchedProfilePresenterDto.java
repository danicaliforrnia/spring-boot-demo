package com.dstefanelli.springbootdemo.presentation.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record MatchedProfilePresenterDto(@JsonProperty("player_id") UUID id,
                                         Integer level,
                                         Integer xp,
                                         @JsonProperty("country") String countryCode,
                                         Map<String, Integer> inventory,
                                         List<String> activeCampaigns) {
}
