package org.example.bookmyshow.models;

import com.fasterxml.jackson.databind.ser.Serializers;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity(name="bookings")
public class Booking extends BaseModel {

    private int noOfSeats;

    private double amount;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @OneToMany(mappedBy = "booking", fetch = FetchType.LAZY)
    private List<Payment> payments;

    @ManyToMany (fetch = FetchType.LAZY) //for cancelled booking we have many to many
    private List<ShowSeat> showSeats;

    @Enumerated(EnumType.STRING)
    private BookingStatus bookingStatus;

    private Date bookingDate;

}
