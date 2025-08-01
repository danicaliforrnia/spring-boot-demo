package com.dstefanelli.springbootdemo.presentation.mapper;

import com.dstefanelli.springbootdemo.application.dto.CampaignDto;
import com.dstefanelli.springbootdemo.application.dto.MatchedProfileDto;
import com.dstefanelli.springbootdemo.domain.model.campaign.Campaign;
import com.dstefanelli.springbootdemo.presentation.dto.MatchedProfilePresenterDto;

public class PlayerProfileDtoToPresenterDtoMapper {

    public static MatchedProfilePresenterDto map(MatchedProfileDto matchedProfileDto) {
        return new MatchedProfilePresenterDto(
                matchedProfileDto.id(),
                matchedProfileDto.level(),
                matchedProfileDto.xp(),
                matchedProfileDto.countryCode(),
                matchedProfileDto.inventory(),
                matchedProfileDto.activeCampaigns().stream().map(CampaignDto::name).toList());
    }
}
