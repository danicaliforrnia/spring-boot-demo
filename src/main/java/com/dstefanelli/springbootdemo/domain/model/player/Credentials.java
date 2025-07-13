package com.dstefanelli.springbootdemo.domain.model.player;

public enum Credentials {
    APPLE("apple_credential"),
    GOOGLE("google_credential");

    public final String label;

    Credentials(String label) {
        this.label = label;
    }
}
