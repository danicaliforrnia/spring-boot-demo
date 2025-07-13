package com.dstefanelli.springbootdemo.domain.model.campaign;

import com.dstefanelli.springbootdemo.domain.model.player.PlayerProfile;

import java.util.List;

public class HasInventoryItemMatcher implements Matcher {
    private final List<String> requiredItems;

    public HasInventoryItemMatcher(List<String> requiredItems) {
        this.requiredItems = requiredItems;
    }

    public boolean matches(PlayerProfile profile) {
        return requiredItems.stream().allMatch(profile::hasItem);
    }
}