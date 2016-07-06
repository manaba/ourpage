package com.tammy.ourpage.model;

/**
 * Created by tammy on 16/5/7.
 */
public enum Privacy {
    ALL(0);

    private final int value;
    private Privacy(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
