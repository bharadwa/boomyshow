package org.example.bookmyshow.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity(name="payments")
public class Payment extends BaseModel {

    @Enumerated(EnumType.STRING)
    private PaymentMode mode;

    private Date paymentDate;

    private String paymentReferenceId;

    private double amount;

    @Enumerated(EnumType.STRING)
    private PaymentStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    private Booking booking;


}
