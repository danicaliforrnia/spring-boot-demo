package com.dstefanelli.springbootdemo.domain.model;

import java.util.List;
import java.util.Map;

public class PlayerCampaignMatcher {
    public static boolean matches(PlayerProfile profile, Campaign campaign) {
        boolean levelMatch = PlayerCampaignMatcher.matchLevel(profile.getLevel(), campaign.getMatchers().getLevel());
        boolean countryMatch = PlayerCampaignMatcher.matchCountries(profile.getCountryCode(), campaign.getMatchers().getHas().getCountry());
        boolean hasItems = PlayerCampaignMatcher.hasItems(profile.getInventory(), campaign.getMatchers().getHas().getItems());
        boolean doesNotHaveItems = PlayerCampaignMatcher.hasNoItems(profile.getInventory(), campaign.getMatchers().getDoesNotHave().getItems());
        return campaign.getEnabled() && levelMatch && countryMatch && hasItems && doesNotHaveItems;
    }

    private static boolean matchLevel(Integer level, CampaignMatchers.Level campaignLevelRanges) {
        return level >= campaignLevelRanges.getMin()
                && level <= campaignLevelRanges.getMax();
    }

    private static boolean matchCountries(String countryCode, List<String> countries) {
        return countries.contains(countryCode);
    }

    private static boolean hasItems(Map<String, Integer> playerInventory, List<String> items) {
        return items.stream()
                .allMatch(playerInventory::containsKey);
    }

    private static boolean hasNoItems(Map<String, Integer> playerInventory, List<String> items) {
        return items.stream()
                .noneMatch(playerInventory::containsKey);
    }
}