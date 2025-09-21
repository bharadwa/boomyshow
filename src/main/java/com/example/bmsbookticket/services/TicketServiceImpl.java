package com.example.bmsbookticket.services;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.example.bmsbookticket.models.Seat;
import com.example.bmsbookticket.models.SeatStatus;
import com.example.bmsbookticket.models.ShowSeat;
import com.example.bmsbookticket.models.Ticket;
import com.example.bmsbookticket.models.TicketStatus;
import com.example.bmsbookticket.models.User;
import com.example.bmsbookticket.repositories.SeatsRepository;
import com.example.bmsbookticket.repositories.ShowRepository;
import com.example.bmsbookticket.repositories.ShowSeatRepository;
import com.example.bmsbookticket.repositories.TicketRepository;
import com.example.bmsbookticket.repositories.UserRepository;

@Service
public class TicketServiceImpl implements TicketService {

    private final UserRepository userRepository;

    private final ShowRepository showRespository;

    private final TicketRepository ticketRepository;

    private final ShowSeatRepository showSeatRepository;

    private final SeatsRepository seatsRepository;

    public TicketServiceImpl(UserRepository userRepository,
            ShowRepository showRepository,
            TicketRepository ticketRepository,

            ShowSeatRepository showSeatRepository,
            SeatsRepository seatsRepository) {

        this.userRepository = userRepository;
        this.ticketRepository = ticketRepository;

        this.showRespository = showRepository;
        this.showSeatRepository = showSeatRepository;
        this.seatsRepository = seatsRepository;
    }

    @Transactional
    @Override
    public Ticket bookTicket(List<Integer> showSeatIds, int userId) throws Exception {
        User user = this.userRepository.findById(userId).orElseThrow(() -> new Exception("User not Found"));
    
        Ticket ticket =new Ticket();

        List<ShowSeat> showSeats=showSeatRepository.findAllByIdInAndStatus(showSeatIds, SeatStatus.AVAILABLE);
        if(CollectionUtils.isEmpty(showSeats)||showSeats.size()!=showSeatIds.size()) {
            throw new Exception("Some seats are already booked please book another seats");
        }
        showSeats.stream().forEach(showSeat->showSeat.setStatus(SeatStatus.BLOCKED));
        showSeatRepository.saveAll(showSeats);
        List<Seat> seats=showSeats.stream().map(showSeat->showSeat.getSeat()).collect(Collectors.toList());
        ticket.setSeats(seats);
        ticket.setShow(showSeats.get(0).getShow());
        ticket.setTimeOfBooking(new Date());
        ticket.setStatus(TicketStatus.UNPAID);
        ticket.setUser(user);

        return ticketRepository.save(ticket);
    }

}
