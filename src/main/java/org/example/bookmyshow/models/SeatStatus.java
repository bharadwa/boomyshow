package org.example.bookmyshow.models;

public enum SeatStatus {

    AVAILABLE,
    BOOKED,
    LOCKED;


    public static SeatStatus fromValue(String value) {
        for(SeatStatus s : SeatStatus.values()) {
            if(s.name().equalsIgnoreCase(value)) {
                return s;
            }
        }
        return null;
    }
}
