package org.example.bookmyshow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name ="show_seats")
public class ShowSeat extends BaseModel {


    @ManyToOne(fetch = FetchType.LAZY)
    private Show show;

    @ManyToOne(fetch =  FetchType.LAZY)
    private Seat seat;

    @Enumerated(EnumType.STRING)
    private SeatStatus seatStatus;


    // ShowSeat (many) --- Show (1)
    // 1 A Booked
    // 1 B Available
    // 1 C Available
    // 1 D Booked
    // 2 A Available
    // 2 B Booked
    // 2 C Available
    // 2 D Available
    // ShowSeat (many) --- Seat (1)
}
