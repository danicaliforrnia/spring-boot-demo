package com.dstefanelli.springbootdemo.domain.model.player;

import lombok.Data;

@Data
public class PlayerDevice {
    private Integer id;
    private String model;
    private String carrier;
    private String firmware;
}
