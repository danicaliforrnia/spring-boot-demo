package com.dstefanelli.springbootdemo.infrastructure.client;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CampaignMatchers {
    private Level level;
    private Has has;
    private DoesNotHave doesNotHave;

    @Data
    @AllArgsConstructor
    public static class Level {
        private int min;
        private int max;
    }

    @Data
    @AllArgsConstructor
    public static class Has {
        private List<String> country;
        private List<String> items;
    }

    @Data
    @AllArgsConstructor
    public static class DoesNotHave {
        private List<String> items;
    }
}