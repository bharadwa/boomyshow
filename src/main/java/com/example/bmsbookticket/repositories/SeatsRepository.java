package com.example.bmsbookticket.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bmsbookticket.models.Seat;

@Repository
public interface SeatsRepository extends JpaRepository<Seat,Integer>{

}
