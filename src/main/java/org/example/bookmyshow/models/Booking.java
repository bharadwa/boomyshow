package org.example.bookmyshow.models;

import com.fasterxml.jackson.databind.ser.Serializers;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name="bookings")
public class Booking extends BaseModel {

    private int ticketCount;

    private double amount;

    @OneToOne(cascade = CascadeType.ALL)
    private User user;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    private List<Payment> payments;

    @OneToMany (fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    private List<ShowSeat> showSeats;

}
