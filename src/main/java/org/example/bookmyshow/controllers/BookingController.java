package org.example.bookmyshow.controllers;

import org.example.bookmyshow.dtos.BookingTicketRequestDTO;
import org.example.bookmyshow.dtos.BookingTicketResponseDTO;
import org.example.bookmyshow.dtos.ResponseStatus;
import org.example.bookmyshow.exceptions.MovieNotFoundException;
import org.example.bookmyshow.exceptions.ShowNotFoundException;
import org.example.bookmyshow.exceptions.UserNotFoundException;
import org.example.bookmyshow.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


@Controller
public class BookingController {

    private final BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }


    public BookingTicketResponseDTO bookingTicket(BookingTicketRequestDTO bookingTicketRequestDTO) {
        BookingTicketResponseDTO response = new BookingTicketResponseDTO();

        try {
            bookingService.bookTicket(bookingTicketRequestDTO.getUserId(),bookingTicketRequestDTO.getShowId(),bookingTicketRequestDTO.getSeatNumbers());
            response.setResponseStatus(ResponseStatus.SUCCESS);
        }   catch (UserNotFoundException | MovieNotFoundException | ShowNotFoundException | RuntimeException e) {
            response.setResponseStatus(ResponseStatus.FAILURE);
        }

        return response;
    }




}
