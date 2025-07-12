package com.dstefanelli.springbootdemo.domain.model;

import lombok.Data;

@Data
public class InventoryItem {
    private String itemCode;
    private Integer quantity;
}
