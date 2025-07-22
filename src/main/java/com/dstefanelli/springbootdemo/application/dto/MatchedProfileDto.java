package com.dstefanelli.springbootdemo.application.dto;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public record MatchedProfileDto(UUID id,
                                Integer level,
                                Integer xp,
                                String countryCode,
                                Map<String, Integer> inventory,
                                List<CampaignDto> activeCampaigns) {
}
