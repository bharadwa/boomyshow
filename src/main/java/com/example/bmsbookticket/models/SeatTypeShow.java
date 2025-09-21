package com.example.bmsbookticket.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class SeatTypeShow extends BaseModel{

    @ManyToOne
    @JoinColumn(name="show_id")
    private Show show;

    @Enumerated(EnumType.STRING)
    private SeatType seatType;
    private double price;
}
