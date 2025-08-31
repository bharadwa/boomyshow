package org.example.bookmyshow.services;

import org.example.bookmyshow.exceptions.MovieNotFoundException;
import org.example.bookmyshow.exceptions.UserNotFoundException;
import org.example.bookmyshow.models.*;
import org.example.bookmyshow.repositories.BookingRepository;
import org.example.bookmyshow.repositories.ShowRepository;
import org.example.bookmyshow.repositories.ShowSeatRepository;
import org.example.bookmyshow.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;

    private final UserRepository userRepository;

    private final ShowRepository showRepository;

    private final ShowSeatRepository showSeatRepository;

    public BookingServiceImpl(BookingRepository bookingRepository,
                              UserRepository userRepository,
                              ShowRepository showRepository,
                              ShowSeatRepository showSeatRepository) {
        this.bookingRepository = bookingRepository;
        this.userRepository = userRepository;
        this.showRepository = showRepository;
        this.showSeatRepository = showSeatRepository;
    }

    @Transactional
    @Override
    public Booking bookTicket(long userId, List<Long> seatNumbers) throws UserNotFoundException, MovieNotFoundException {
        User user= this.userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User Not Found"));

        List< ShowSeat> showSeatList=this.showSeatRepository.findAllByIdInAndSeatStatus(seatNumbers, SeatStatus.AVAILABLE);

        if(showSeatList.size()!=seatNumbers.size()){
            throw new MovieNotFoundException("Some seats are not available");
        }

        for(ShowSeat showSeat:showSeatList){
            showSeat.setSeatStatus(SeatStatus.BLOCKED);
        }

        this.showSeatRepository.saveAll(showSeatList);

        Booking booking=new Booking();
        booking.setUser(user);
        booking.setShowSeats(showSeatList);
        booking.setBookingStatus(BookingStatus.PENDING_PAYMENT);
        booking.setNoOfSeats(seatNumbers.size());
        return this.bookingRepository.save(booking);

    }
}
