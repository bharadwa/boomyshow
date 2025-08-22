package org.example.bookmyshow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name ="show_seats")
public class ShowSeat extends BaseModel {


    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
    private Show show;

    @ManyToOne(fetch =  FetchType.EAGER,cascade = CascadeType.PERSIST)
    private Seat seat;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private SeatType seatType;

    private SeatStatus seatStatus;

}
