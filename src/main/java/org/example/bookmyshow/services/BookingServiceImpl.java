package org.example.bookmyshow.services;

import java.util.List;
import java.util.Optional;

import org.example.bookmyshow.exceptions.MovieNotFoundException;
import org.example.bookmyshow.exceptions.ShowNotFoundException;
import org.example.bookmyshow.exceptions.UserNotFoundException;
import org.example.bookmyshow.models.*;
import org.example.bookmyshow.repositories.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;

    private final UserRepository userRepository;

    private final ShowRepository showRepository;

    private final ShowSeatRepository showSeatRepository;

    private final ShowSeatPriceRepository showSeatPriceRepository;

    private final SeatRepository seatRepository;


    public BookingServiceImpl(BookingRepository bookingRepository,
                              UserRepository userRepository,
                              ShowRepository showRepository,
                              ShowSeatRepository showSeatRepository,
                              ShowSeatPriceRepository showSeatPriceRepository,
                              SeatRepository seatRepository) {
        this.bookingRepository = bookingRepository;
        this.userRepository = userRepository;
        this.showRepository = showRepository;
        this.showSeatRepository = showSeatRepository;
        this.showSeatPriceRepository = showSeatPriceRepository;
        this.seatRepository = seatRepository;
    }

    @Transactional
    @Override
    public Booking bookTicket(long userId,long showId, List<Long> seatNumbers) throws UserNotFoundException, ShowNotFoundException, MovieNotFoundException {

        User user= this.userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User Not Found"));
        Show show =this.showRepository.findById(showId).orElseThrow(() -> new ShowNotFoundException("Show Not Found"));
        List<Seat> seats=this.seatRepository.findAllById(seatNumbers);
        if(seats.size()!=seatNumbers.size()){
            throw new RuntimeException("Some of the selected seats do not exist.");
        }

        // Add this check for seat types
        if (!seats.isEmpty()) {
            // Get the type of the first seat. Let's assume getSeatType() returns an Enum or String.
            SeatType firstSeatType = seats.get(0).getSeatType();

            // Iterate over the rest of the seats to check their type
            for (int i = 1; i < seats.size(); i++) {
                if (seats.get(i).getSeatType() != firstSeatType) {
                    throw new RuntimeException("All selected seats must be of the same type. You cannot mix seat types in one booking.");
                }
            }
        }

        List<ShowSeat> showSeatList=this.showSeatRepository.findAllByIdInAndShowIdAndSeatStatus(seatNumbers,show.getId(),SeatStatus.AVAILABLE);
        if(showSeatList.size()!=seatNumbers.size()){
            throw new RuntimeException("Some seats are not available for booking.");
        }

        for(ShowSeat showSeat:showSeatList){
            showSeat.setSeatStatus(SeatStatus.BLOCKED);
        }

        this.showSeatRepository.saveAll(showSeatList);

        Optional<ShowSeatPrice> showSeatPrice= this.showSeatPriceRepository.findByShowIdAndSeatType(showSeatList.get(0).getShow().getId(),showSeatList.get(0).getSeat().getSeatType());
        Booking booking=new Booking();
        booking.setUser(user);
        booking.setShowSeats(showSeatList);
        booking.setBookingStatus(BookingStatus.PENDING_PAYMENT);
        booking.setNoOfSeats(seatNumbers.size());
        if(showSeatPrice.isPresent()){
            booking.setAmount(seatNumbers.size()*showSeatPrice.get().getPrice());
        }else {
            booking.setAmount(seatNumbers.size()*100);
        }
        return this.bookingRepository.save(booking);

    }
}
