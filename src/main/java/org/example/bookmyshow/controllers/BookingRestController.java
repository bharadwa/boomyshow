package org.example.bookmyshow.controllers;

import org.example.bookmyshow.dtos.BookingTicketRequestDTO;
import org.example.bookmyshow.dtos.BookingTicketResponseDTO;
import org.example.bookmyshow.dtos.ResponseStatus;
import org.example.bookmyshow.exceptions.MovieNotFoundException;
import org.example.bookmyshow.exceptions.ShowNotFoundException;
import org.example.bookmyshow.exceptions.UserNotFoundException;
import org.example.bookmyshow.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/bookings")
@RestController
public class BookingRestController {

    private final BookingService bookingService;

    @Autowired
    public BookingRestController(BookingService bookingService) {
        this.bookingService = bookingService;
    }


    @PostMapping("/book")
    public BookingTicketResponseDTO bookTicket(@RequestBody  BookingTicketRequestDTO bookingTicketRequestDTO) {
        BookingTicketResponseDTO response = new BookingTicketResponseDTO();

        try {
            bookingService.bookTicket(bookingTicketRequestDTO.getUserId(),bookingTicketRequestDTO.getShowId(),bookingTicketRequestDTO.getSeatNumbers());
            response.setResponseStatus(ResponseStatus.SUCCESS);
        }  catch (UserNotFoundException | MovieNotFoundException | ShowNotFoundException | RuntimeException e) {
            response.setResponseStatus(ResponseStatus.FAILURE);
        }

        return response;
    }
}
