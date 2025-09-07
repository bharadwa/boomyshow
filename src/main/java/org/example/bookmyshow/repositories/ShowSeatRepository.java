package org.example.bookmyshow.repositories;

import jakarta.persistence.LockModeType;
import org.example.bookmyshow.models.SeatStatus;
import org.example.bookmyshow.models.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeat,Long> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    List<ShowSeat> findAllByIdInAndShowIdAndSeatStatus(Iterable<Long>ids,Long showId, SeatStatus seatStatus);
}
