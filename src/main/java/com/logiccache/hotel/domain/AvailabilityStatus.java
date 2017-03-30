package com.logiccache.hotel.domain;

public enum AvailabilityStatus {
    BOOKED("Booked"),
    AVAILABLE("Available");

    private final String value;

    AvailabilityStatus(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}