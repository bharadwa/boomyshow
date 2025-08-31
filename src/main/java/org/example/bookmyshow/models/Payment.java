package org.example.bookmyshow.models;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
