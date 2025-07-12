package com.dstefanelli.springbootdemo.infrastructure.database.entities;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeviceEntity {
    private Integer id;
    private String model;
    private String carrier;
    private String firmware;
}