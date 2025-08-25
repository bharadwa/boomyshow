package org.example.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name ="seats")
public class Seat extends BaseModel {
    private int seatRow;
    private int seatCol;
    private String seatNumber;
    @ManyToOne(fetch = FetchType.LAZY)
    private Screen screen;
}
