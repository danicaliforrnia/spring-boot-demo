package com.dstefanelli.springbootdemo.presentation.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.UUID;

public record MatchedProfilePresenterDto(@JsonProperty("player_id") UUID playerId,
                                         @JsonProperty("active_campaigns") List<String> activeCampaigns) {
}
