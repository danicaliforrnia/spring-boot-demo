package com.dstefanelli.springbootdemo.domain.model;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Builder
public class PlayerProfile {
    @Getter
    private UUID id;
    private Clan clan;
    private Gender gender;
    private LocalDate birthdate;
    @Getter
    private Integer level;
    private Integer xp;
    private Integer totalPlaytimeMinutes;
    @Getter
    private String countryCode;
    private String language;
    private Credentials credential;
    private Integer totalSpent;
    private Integer totalRefund;
    private Integer totalTransactions;
    @Getter
    private Map<String, Integer> inventory;
    private List<PlayerDevice> devices;
    private LocalDateTime created;
    private LocalDateTime modified;
    private LocalDateTime lastSession;
    private LocalDateTime lastPurchase;

    public List<Campaign> getActiveCampaigns(List<Campaign> currentCampaigns) {
        return currentCampaigns.stream().filter(campaign -> CampaignMatcher.matches(this, campaign)).toList();
    }
}
