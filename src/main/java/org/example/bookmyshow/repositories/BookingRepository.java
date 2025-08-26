package org.example.bookmyshow.repositories;

import org.example.bookmyshow.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
