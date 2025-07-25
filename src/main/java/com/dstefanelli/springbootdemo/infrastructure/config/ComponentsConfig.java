package com.dstefanelli.springbootdemo.infrastructure.config;

import com.dstefanelli.springbootdemo.application.usecase.DefaultMatchCampaignsToPlayerProfileUseCase;
import com.dstefanelli.springbootdemo.application.usecase.MatchCampaignsToPlayerProfileUseCase;
import com.dstefanelli.springbootdemo.infrastructure.client.MockCampaignsClient;
import com.dstefanelli.springbootdemo.infrastructure.database.repository.PostgresPlayerProfileRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ComponentsConfig {

    private final PostgresPlayerProfileRepository postgresPlayerProfileRepository;

    private final MockCampaignsClient campaignsClient;

    public ComponentsConfig(PostgresPlayerProfileRepository postgresPlayerProfileRepository,
                            MockCampaignsClient campaignsClient) {
        this.postgresPlayerProfileRepository = postgresPlayerProfileRepository;
        this.campaignsClient = campaignsClient;
    }

    @Bean
    public MatchCampaignsToPlayerProfileUseCase matchCampaignsToPlayerProfileUseCase() {
        return new DefaultMatchCampaignsToPlayerProfileUseCase(postgresPlayerProfileRepository, campaignsClient);
    }

}
