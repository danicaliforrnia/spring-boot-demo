package com.dstefanelli.springbootdemo.infrastructure.client;

import com.dstefanelli.springbootdemo.domain.model.campaign.Campaign;
import com.dstefanelli.springbootdemo.domain.service.CampaignsClient;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MockCampaignsClient implements CampaignsClient {
    private final List<CampaignResponse> campaignResponse = List.of(
            new CampaignResponse("mygame",
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
            ),
            new CampaignResponse("mygame2",
                    "mycampaign2",
                    9.0,
                    true,
                    new CampaignMatchers(
                            new CampaignMatchers.Level(5, 10),
                            new CampaignMatchers.Has(List.of("US", "RO", "CA"), List.of("item_1")),
                            new CampaignMatchers.DoesNotHave(List.of("item_4"))
                    ),
                    LocalDateTime.now().minusDays(1),
                    LocalDateTime.now().plusDays(7),
                    LocalDateTime.now()
            )
    );

    @Override
    public List<Campaign> fetchCurrentCampaigns() {
        return campaignResponse.stream().map(CampaignAdapter::new).collect(Collectors.toUnmodifiableList());
    }
}
