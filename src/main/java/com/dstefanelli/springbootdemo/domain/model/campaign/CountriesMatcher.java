package com.dstefanelli.springbootdemo.domain.model.campaign;

import com.dstefanelli.springbootdemo.domain.model.player.PlayerProfile;

import java.util.List;

public class CountriesMatcher implements Matcher {
    private final List<String> allowedCountries;

    public CountriesMatcher(List<String> allowedCountries) {
        this.allowedCountries = allowedCountries;
    }

    public boolean matches(PlayerProfile profile) {
        return allowedCountries.contains(profile.getCountryCode());
    }
}