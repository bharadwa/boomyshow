package org.example.bookmyshow.dtos;

import lombok.Data;
import org.example.bookmyshow.models.Booking;

import java.io.Serializable;

@Data
public class BookingTicketResponseDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Booking booking;

    private ResponseStatus responseStatus;

}
