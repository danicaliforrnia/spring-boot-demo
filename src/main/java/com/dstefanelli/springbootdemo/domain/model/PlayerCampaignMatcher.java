package com.dstefanelli.springbootdemo.domain.model;

public class PlayerCampaignMatcher {
    public static boolean matches(PlayerProfile profile, Campaign campaign) {
        boolean levelMatch = profile.getLevel() >= campaign.getMatchers().getLevel().getMin()
                && profile.getLevel() <= campaign.getMatchers().getLevel().getMax();

        boolean countryMatch = campaign.getMatchers().getHas().getCountry().contains(profile.getCountryCode());

        boolean hasItems = campaign.getMatchers().getHas().getItems().stream()
                .allMatch(item -> profile.getInventory().containsKey(item));

        boolean doesNotHaveItems = campaign.getMatchers().getDoesNotHave().getItems().stream()
                .noneMatch(item -> profile.getInventory().containsKey(item));

        return levelMatch && countryMatch && hasItems && doesNotHaveItems;
    }
}