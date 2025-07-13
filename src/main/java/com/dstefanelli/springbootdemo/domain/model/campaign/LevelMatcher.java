package com.dstefanelli.springbootdemo.domain.model.campaign;

import com.dstefanelli.springbootdemo.domain.model.player.PlayerProfile;

public class LevelMatcher implements Matcher {
    private final int min;
    private final int max;

    public LevelMatcher(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public boolean matches(PlayerProfile profile) {
        int level = profile.getLevel();
        return level >= min && level <= max;
    }
}