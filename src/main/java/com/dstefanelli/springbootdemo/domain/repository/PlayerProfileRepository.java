package com.dstefanelli.springbootdemo.domain.repository;

import com.dstefanelli.springbootdemo.domain.model.player.PlayerProfile;

import java.util.Optional;
import java.util.UUID;

public interface PlayerProfileRepository {
    Optional<PlayerProfile> findById(UUID playerProfileId);
}
