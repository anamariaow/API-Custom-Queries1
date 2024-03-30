package com.example.APICustom.Queries1.enums;

public enum StatusEnum {
    ONTIME("On time"),
    DELAYED("Delayed"),
    CANCELLED("Cancelled");
    private String description;

    StatusEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
