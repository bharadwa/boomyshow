package org.example.bookmyshow.services;

import org.example.bookmyshow.dtos.BookingTicketResponseDTO;
import org.example.bookmyshow.exceptions.MovieNotFoundException;
import org.example.bookmyshow.exceptions.UserNotFoundException;
import org.example.bookmyshow.models.Booking;

import java.util.List;

public interface BookingService {

    Booking bookTicket(long userId, List<Long> seatNumbers) throws UserNotFoundException, MovieNotFoundException;
}
