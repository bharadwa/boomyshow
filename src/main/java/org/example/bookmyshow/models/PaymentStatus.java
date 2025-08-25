package org.example.bookmyshow.models;

public enum PaymentStatus {

    PENDING,
    COMPLETED,
    FAILED,
    REFUNDED,
    CANCELLED;

    public static PaymentStatus fromString(String status) {
        for (PaymentStatus ps : PaymentStatus.values()) {
            if (ps.name().equalsIgnoreCase(status)) {
                return ps;
            }
        }
        return null;
    }
}
