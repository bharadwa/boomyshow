package org.example.bookmyshow.models;

public enum PaymentMode {

    UPI,
    CARD,
    INTERNET_BANKING;

    public static PaymentMode fromString(String value) {
        for (PaymentMode mode : PaymentMode.values()) {
            if (mode.name().equalsIgnoreCase(value)) {
                return mode;
            }
        }
        return null;
    }
}
