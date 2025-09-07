package org.example.bookmyshow.repositories;

import org.example.bookmyshow.models.SeatType;
import org.example.bookmyshow.models.ShowSeatPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface ShowSeatPriceRepository extends JpaRepository<ShowSeatPrice,Long> {


    Optional<ShowSeatPrice> findByShowIdAndSeatType(long id, SeatType seatType);
}
