package org.example.bookmyshow.repositories;

import org.example.bookmyshow.models.ShowSeatPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowSeatPriceRepository extends JpaRepository<ShowSeatPrice,Long> {

}
