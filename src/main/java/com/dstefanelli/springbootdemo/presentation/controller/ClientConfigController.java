package com.dstefanelli.springbootdemo.presentation.controller;

import com.dstefanelli.springbootdemo.application.usecase.MatchCampaignsToPlayerProfileUseCase;
import com.dstefanelli.springbootdemo.presentation.dto.MatchedProfilePresenterDto;
import com.dstefanelli.springbootdemo.presentation.mapper.PlayerProfileDtoToPresenterDtoMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("get_client_config")
public class ClientConfigController {
    private final MatchCampaignsToPlayerProfileUseCase matchCampaignsToPlayerProfileUseCase;

    public ClientConfigController(MatchCampaignsToPlayerProfileUseCase matchCampaignsToPlayerProfileUseCase) {
        this.matchCampaignsToPlayerProfileUseCase = matchCampaignsToPlayerProfileUseCase;
    }

    @GetMapping("/{playerId}")
    public ResponseEntity<MatchedProfilePresenterDto> getProfileWithCampaigns(@PathVariable UUID playerId) {
        var result = matchCampaignsToPlayerProfileUseCase.execute(playerId);
        return ResponseEntity.ok(PlayerProfileDtoToPresenterDtoMapper.map(result));
    }
}
