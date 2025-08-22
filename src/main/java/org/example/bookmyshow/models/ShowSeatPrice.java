package org.example.bookmyshow.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity(name="show_seat_price")
public class ShowSeatPrice extends BaseModel {

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Show show;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private SeatType seatType;

    private double price;

}
