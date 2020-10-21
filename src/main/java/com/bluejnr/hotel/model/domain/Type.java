package com.bluejnr.hotel.model.domain;

public enum Type {

    STANDARD(3),
    NORMAL(4),
    SUITE(6);

    private final Integer value;

    Type(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
