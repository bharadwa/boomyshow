package org.example.bookmyshow.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name ="seats")
public class Seat extends BaseModel {
    private int seatRow;
    private int seatCol;
    private String seatNumber;
}
