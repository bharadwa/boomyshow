package com.example.bmsbookticket.models;

import lombok.Data;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
@Entity
@Data
public class Ticket extends BaseModel{

    @ManyToOne
    @JoinColumn(name="show_id")
    private Show show;

    @ManyToMany
    @JoinTable(name="tickets_seats")
    List<Seat> seats;

    private Date timeOfBooking;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @Enumerated(EnumType.STRING)
    private TicketStatus status;
}
