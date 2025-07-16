
package com.dstefanelli.springbootdemo.domain;

import com.dstefanelli.springbootdemo.domain.model.campaign.*;
import com.dstefanelli.springbootdemo.domain.model.player.PlayerProfile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class PlayerProfileTest {
    private PlayerProfile playerProfile;

    @BeforeEach
    void setUp() {
        Map<String, Integer> inventory = Map.of("item_1", 1);
        playerProfile = PlayerProfile.builder()
                .level(3)
                .countryCode("US")
                .inventory(inventory)
                .build();
    }

    @Test
    void testHasItem() {
        assertTrue(playerProfile.hasItem("item_1"));
        assertFalse(playerProfile.hasItem("item_2"));
    }

    @Test
    void testLacksItem() {
        assertTrue(playerProfile.lacksItem("item_2"));
        assertFalse(playerProfile.lacksItem("item_1"));
    }

    @Test
    void testHasActivateCampaign() {
        var campaigns = List.of(
                new Campaign(
                        "mygame",
                        "mycampaign",
                        10.5,
                        true,
                        List.of(
                                new LevelMatcher(1, 3),
                                new CountriesMatcher(List.of("US", "RO", "CA")),
                                new HasInventoryItemMatcher(List.of("item_1")),
                                new DoesNotHaveInventoryItemMatcher(List.of("item_4"))
                        ),
                        LocalDateTime.of(2025, 1, 25, 0, 0),
                        LocalDateTime.of(2026, 2, 25, 0, 0),
                        LocalDateTime.of(2024, 7, 13, 11, 46, 58)
                ),
                new Campaign(
                        "mygame",
                        "mycampaign2",
                        5.0,
                        true,
                        List.of(
                                new LevelMatcher(1, 3),
                                new CountriesMatcher(List.of("US", "RO", "CA")),
                                new HasInventoryItemMatcher(List.of("item_2")),
                                new DoesNotHaveInventoryItemMatcher(List.of("item_55"))
                        ),
                        LocalDateTime.of(2022, 1, 25, 0, 0),
                        LocalDateTime.of(2022, 2, 25, 0, 0),
                        LocalDateTime.of(2021, 7, 13, 11, 46, 58)
                )
        );
        assertFalse(playerProfile.getActiveCampaigns(campaigns).isEmpty());
    }
}
