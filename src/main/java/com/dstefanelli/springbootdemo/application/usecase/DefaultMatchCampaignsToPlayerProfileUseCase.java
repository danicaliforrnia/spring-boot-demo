package com.dstefanelli.springbootdemo.application.usecase;

import com.dstefanelli.springbootdemo.application.dto.MatchedProfileDto;
import com.dstefanelli.springbootdemo.domain.model.player.PlayerProfile;
import com.dstefanelli.springbootdemo.application.exceptions.PlayerProfileNotFound;
import com.dstefanelli.springbootdemo.domain.repository.PlayerProfileRepository;
import com.dstefanelli.springbootdemo.domain.service.CampaignsClient;

import java.util.UUID;

public class DefaultMatchCampaignsToPlayerProfileUseCase implements MatchCampaignsToPlayerProfileUseCase {
    private final PlayerProfileRepository playerProfileRepository;
    private final CampaignsClient campaignsClient;

    public DefaultMatchCampaignsToPlayerProfileUseCase(
            PlayerProfileRepository playerProfileRepository,
            CampaignsClient campaignsClient) {
        this.playerProfileRepository = playerProfileRepository;
        this.campaignsClient = campaignsClient;
    }

    public MatchedProfileDto execute(UUID playerId) {
        PlayerProfile profile = playerProfileRepository.findById(playerId)
                .orElseThrow(() -> new PlayerProfileNotFound(playerId));
        var currentCampaigns = campaignsClient.fetchCurrentCampaigns();
        return new MatchedProfileDto(profile.getId(),
                profile.getLevel(),
                profile.getXp(),
                profile.getCountryCode(),
                profile.getInventory(),
                profile.getActiveCampaigns(currentCampaigns));
    }
}
