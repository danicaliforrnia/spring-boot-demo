package com.dstefanelli.springbootdemo.application.exceptions;

import java.util.UUID;

public class PlayerProfileNotFound
        extends RuntimeException {
    public PlayerProfileNotFound(UUID id) {
        super("Player Profile not found with id " + id);
    }
}