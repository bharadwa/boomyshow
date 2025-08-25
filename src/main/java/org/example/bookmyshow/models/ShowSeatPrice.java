package org.example.bookmyshow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity(name="show_seat_prices")
public class ShowSeatPrice extends BaseModel {

    @ManyToOne(fetch = FetchType.LAZY)
    private Show show;

    @ManyToOne(fetch = FetchType.LAZY)
    private SeatType seatType;

    private double price;

   // ShowSeat PRice (many) --- show (1)
    // 1 show seat Price is present in one show
    // 1 show contains multiple show seat price --->

   // 1 A 100    ---> (show)
   // 1 B 200
   // 2 A 150

   // Show Seat Price (many) --- Seat Type (1)
}
