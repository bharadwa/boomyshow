package org.example.bookmyshow.models;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="bookings")
public class Booking extends BaseModel {

    private int noOfSeats;

    private double amount;

    @ManyToOne(fetch = FetchType.LAZY)
    private User bookedBy;

    @OneToMany(mappedBy = "booking", fetch = FetchType.LAZY)
    private List<Payment> payments;

    @ManyToMany (fetch = FetchType.LAZY) //for cancelled booking we have many to many
    private List<ShowSeat> showSeats;

    @Enumerated(EnumType.STRING)
    private BookingStatus bookingStatus;

    private Date bookingDate;

}
