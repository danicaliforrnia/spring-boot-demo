package com.dstefanelli.springbootdemo.domain.model.campaign;

import com.dstefanelli.springbootdemo.domain.model.player.PlayerProfile;

public interface Matcher {
    boolean matches(PlayerProfile profile);
}