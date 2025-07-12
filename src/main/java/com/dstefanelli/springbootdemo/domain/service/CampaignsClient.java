package com.dstefanelli.springbootdemo.domain.service;

import com.dstefanelli.springbootdemo.domain.model.Campaign;

import java.util.List;

public interface CampaignsClient {
    List<Campaign> fetchCurrentCampaigns();
}
