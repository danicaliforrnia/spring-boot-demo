package com.dstefanelli.springbootdemo.infrastructure.client;

import com.dstefanelli.springbootdemo.domain.model.Campaign;
import com.dstefanelli.springbootdemo.domain.model.CampaignMatchers;
import com.dstefanelli.springbootdemo.domain.service.CampaignsClient;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MockCampaignsClient implements CampaignsClient {
    @Override
    public List<Campaign> fetchCurrentCampaigns() {
        return List.of(
                new Campaign("mygame",
                        "mycampaign",
                        10.5,
                        true,
                        new CampaignMatchers(
                                new CampaignMatchers.Level(1, 3),
                                new CampaignMatchers.Has(List.of("US", "RO", "CA"), List.of("item_1")),
                                new CampaignMatchers.DoesNotHave(List.of("item_4"))
                        ),
                        LocalDateTime.now().minusDays(1),
                        LocalDateTime.now().plusDays(7),
                        LocalDateTime.now()
                )
        );
    }
}
