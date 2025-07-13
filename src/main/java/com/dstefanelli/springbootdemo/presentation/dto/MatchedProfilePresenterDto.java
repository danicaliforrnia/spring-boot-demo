package com.dstefanelli.springbootdemo.presentation.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public record MatchedProfilePresenterDto(@JsonProperty("player_id") UUID id,
                                         Integer level,
                                         Integer xp,
                                         @JsonProperty("country") String countryCode,
                                         Map<String, Integer> inventory,
                                         @JsonProperty("active_campaigns") List<String> activeCampaigns) {
}
