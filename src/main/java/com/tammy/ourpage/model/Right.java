package com.tammy.ourpage.model;

/**
 * Created by tammy on 16/5/7.
 */
public enum Right {
    ALL(0);

    private final int value;
    private Right(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
