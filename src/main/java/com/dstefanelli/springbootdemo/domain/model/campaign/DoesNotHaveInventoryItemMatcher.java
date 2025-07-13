package com.dstefanelli.springbootdemo.domain.model.campaign;

import com.dstefanelli.springbootdemo.domain.model.player.PlayerProfile;

import java.util.List;

public class DoesNotHaveInventoryItemMatcher implements Matcher {
    private final List<String> forbiddenItems;

    public DoesNotHaveInventoryItemMatcher(List<String> forbiddenItems) {
        this.forbiddenItems = forbiddenItems;
    }

    public boolean matches(PlayerProfile profile) {
        return forbiddenItems.stream().allMatch(profile::lacksItem);
    }
}