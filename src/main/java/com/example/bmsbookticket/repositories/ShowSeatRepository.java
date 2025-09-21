package com.example.bmsbookticket.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;

import com.example.bmsbookticket.models.SeatStatus;

import com.example.bmsbookticket.models.ShowSeat;

import jakarta.persistence.LockModeType;

@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeat,Integer>  {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    List<ShowSeat> findAllByIdInAndStatus(Iterable<Integer> ids, SeatStatus seatStatus);
}
