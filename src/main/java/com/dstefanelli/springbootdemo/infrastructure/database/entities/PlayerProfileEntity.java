package com.dstefanelli.springbootdemo.infrastructure.database.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Entity
@Table(name = "player_profile")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerProfileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @Column(nullable = false)
    private String credential;

    @Column(nullable = false)
    private Integer level;

    @Column()
    private Integer xp;

    @Column(name = "country_code", nullable = false)
    private String countryCode;

    @Column(name = "total_playtime_minutes")
    private int totalPlaytime;

    @Column()
    private String language;

    @Column()
    private LocalDateTime birthdate;

    @Column()
    private String gender;

    @Column(name = "total_spent")
    private Integer totalSpent;

    @Column(name = "total_refund")
    private Integer totalRefund;

    @Column(name = "total_transactions")
    private Integer totalTransactions;

    @Column()
    private LocalDateTime created;

    @Column()
    private LocalDateTime modified;

    @Column(name = "last_session")
    private LocalDateTime lastSession;

    @Column(name = "last_purchase")
    private LocalDateTime lastPurchase;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "clan_id",
            referencedColumnName = "id"
    )
    private ClanEntity clan;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "player_device", joinColumns = @JoinColumn(name = "player_id"))
    private List<DeviceEntity> devices;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "inventory_item", joinColumns = @JoinColumn(name = "player_id"))
    @MapKeyColumn(name = "item_code")
    @Column(name = "quantity")
    private Map<String, Integer> inventory;
}