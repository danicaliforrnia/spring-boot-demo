package com.dstefanelli.springbootdemo.domain.model.player;

import com.dstefanelli.springbootdemo.domain.model.campaign.Campaign;
import com.dstefanelli.springbootdemo.domain.model.campaign.PlayerCampaignMatcher;
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
    @Getter
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
        return currentCampaigns.stream().filter(campaign -> PlayerCampaignMatcher.matches(this, campaign)).toList();
    }

    public boolean hasItem(String item) {
        return inventory.containsKey(item) && inventory.get(item) > 0;
    }

    public boolean lacksItem(String item) {
        return !inventory.containsKey(item) || inventory.get(item) <= 0;
    }

}
