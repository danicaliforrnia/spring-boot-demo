package com.dstefanelli.springbootdemo.infrastructure.database.mapper;

import com.dstefanelli.springbootdemo.domain.model.player.Clan;
import com.dstefanelli.springbootdemo.domain.model.player.PlayerProfile;
import com.dstefanelli.springbootdemo.infrastructure.database.entities.PlayerProfileEntity;

public class PlayerProfileEntityToModelMapper {

    public static PlayerProfile map(PlayerProfileEntity playerProfileEntity) {
        return PlayerProfile.builder()
                .id(playerProfileEntity.getId())
                .clan(new Clan(playerProfileEntity.getClan().getId(), playerProfileEntity.getClan().getName()))
                .level(playerProfileEntity.getLevel())
                .xp(playerProfileEntity.getXp())
                .totalPlaytimeMinutes(playerProfileEntity.getTotalPlaytime())
                .countryCode(playerProfileEntity.getCountryCode())
                .inventory(playerProfileEntity.getInventory())
                .build();
    }
}
