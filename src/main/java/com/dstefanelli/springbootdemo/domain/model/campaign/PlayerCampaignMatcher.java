package com.dstefanelli.springbootdemo.domain.model.campaign;

import com.dstefanelli.springbootdemo.domain.model.player.PlayerProfile;

import java.time.LocalDateTime;

public class PlayerCampaignMatcher {
    public static boolean matches(PlayerProfile profile, Campaign campaign) {
        if (!campaign.getEnabled()) return false;
        LocalDateTime now = LocalDateTime.now();
        if (now.isBefore(campaign.getStartDate()) || now.isAfter(campaign.getEndDate())) return false;
        return campaign.getMatchers().stream().allMatch(m -> m.matches(profile));
    }
}