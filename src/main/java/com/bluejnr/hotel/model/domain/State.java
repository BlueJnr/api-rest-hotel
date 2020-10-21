package com.bluejnr.hotel.model.domain;

public enum State {

    FREE("libre"),
    BUSY("ocupada"),
    MAINTENANCE("mantenimiento"),
    CLEANING("limpieza"),;

    private final String value;

    State(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
