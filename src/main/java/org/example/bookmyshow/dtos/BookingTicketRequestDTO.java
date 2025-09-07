package org.example.bookmyshow.dtos;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class BookingTicketRequestDTO implements Serializable {

    private long userId;

    private long showId;

    private List<Long> seatNumbers;


}
