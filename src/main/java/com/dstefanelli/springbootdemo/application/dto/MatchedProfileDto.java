package com.dstefanelli.springbootdemo.application.dto;

import com.dstefanelli.springbootdemo.domain.model.Campaign;

import java.util.List;
import java.util.UUID;

public record MatchedProfileDto(UUID playerId, List<Campaign> activeCampaigns) {
}
