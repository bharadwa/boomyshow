package org.example.bookmyshow.services;

import java.util.List;

import org.example.bookmyshow.exceptions.MovieNotFoundException;
import org.example.bookmyshow.exceptions.ShowNotFoundException;
import org.example.bookmyshow.exceptions.UserNotFoundException;
import org.example.bookmyshow.models.Booking;

public interface BookingService {

    Booking bookTicket(long userId,long showId, List<Long> seatNumbers) throws UserNotFoundException, ShowNotFoundException, MovieNotFoundException;
}
