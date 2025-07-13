package com.dstefanelli.springbootdemo.infrastructure.client;

import com.dstefanelli.springbootdemo.domain.model.campaign.*;

import java.util.List;

public class CampaignAdapter extends Campaign {
    public CampaignAdapter(CampaignResponse campaignResponse) {
        super(campaignResponse.getGame(),
                campaignResponse.getName(),
                campaignResponse.getPriority(),
                campaignResponse.getEnabled(),
                List.of(
                        new LevelMatcher(campaignResponse.getMatchers().getLevel().getMin(),
                                campaignResponse.getMatchers().getLevel().getMax()),
                        new CountriesMatcher(campaignResponse.getMatchers().getHas().getCountry()),
                        new HasInventoryItemMatcher(campaignResponse.getMatchers().getHas().getItems()),
                        new DoesNotHaveInventoryItemMatcher(campaignResponse.getMatchers().getDoesNotHave().getItems())
                ),
                campaignResponse.getStartDate(),
                campaignResponse.getEndDate(),
                campaignResponse.getLastUpdated());
    }
}
