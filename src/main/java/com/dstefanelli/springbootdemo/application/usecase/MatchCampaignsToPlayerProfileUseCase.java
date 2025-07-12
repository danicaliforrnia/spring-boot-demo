package com.dstefanelli.springbootdemo.application.usecase;

import com.dstefanelli.springbootdemo.application.dto.MatchedProfileDto;

import java.util.UUID;

public interface MatchCampaignsToPlayerProfileUseCase {
    MatchedProfileDto execute(UUID playerId);
}
