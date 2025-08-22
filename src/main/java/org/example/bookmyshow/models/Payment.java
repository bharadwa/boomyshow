package org.example.bookmyshow.models;

import jakarta.persistence.Entity;

@Entity(name="payments")
public class Payment extends BaseModel {


    private PaymentMode mode;

    private String paymentReferenceId;

    private double amount;


}
