package com.example.bmsbookticket.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class ShowSeat extends BaseModel{
    @ManyToOne
    @JoinColumn(name="show_id")
    private Show show;
    
    @ManyToOne
    @JoinColumn(name="seat_id")
    private Seat seat;

    @Enumerated(EnumType.STRING)
    private SeatStatus status;
}
