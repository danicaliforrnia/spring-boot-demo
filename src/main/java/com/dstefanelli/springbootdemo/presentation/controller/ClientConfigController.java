package com.dstefanelli.springbootdemo.presentation.controller;

import com.dstefanelli.springbootdemo.application.usecase.MatchCampaignsToPlayerProfileUseCase;
import com.dstefanelli.springbootdemo.presentation.dto.MatchedProfilePresenterDto;
import com.dstefanelli.springbootdemo.presentation.errors.ErrorResponse;
import com.dstefanelli.springbootdemo.presentation.mapper.PlayerProfileDtoToPresenterDtoMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("get_client_config")
@Tag(name = "Client Config", description = "Endpoints for client configuration and active campaigns")
public class ClientConfigController {
    private final MatchCampaignsToPlayerProfileUseCase matchCampaignsToPlayerProfileUseCase;

    public ClientConfigController(MatchCampaignsToPlayerProfileUseCase matchCampaignsToPlayerProfileUseCase) {
        this.matchCampaignsToPlayerProfileUseCase = matchCampaignsToPlayerProfileUseCase;
    }

    @GetMapping(value = "/{playerId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get player active campaigns", description = "Get player active campaigns by providing the player id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Player found with a list of active campaigns (or empty)",
                    content = @Content(schema = @Schema(implementation = MatchedProfilePresenterDto.class))),
            @ApiResponse(responseCode = "404", description = "Player not found",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    public ResponseEntity<MatchedProfilePresenterDto> getProfileWithCampaigns(@PathVariable UUID playerId) {
        var result = matchCampaignsToPlayerProfileUseCase.execute(playerId);
        return ResponseEntity.ok(PlayerProfileDtoToPresenterDtoMapper.map(result));
    }
}
