package com.example.bmsbookticket.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bmsbookticket.models.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket,Integer>{

}
