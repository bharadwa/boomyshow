package org.example.bookmyshow.repositories;

import org.example.bookmyshow.models.SeatType;
import org.example.bookmyshow.models.ShowSeatType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShowSeatTypeRepository extends JpaRepository<ShowSeatType,Long> {


    Optional<ShowSeatType> findByShowIdAndSeatType(long id, SeatType seatType);
}
