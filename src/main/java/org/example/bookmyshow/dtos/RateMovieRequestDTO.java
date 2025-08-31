package org.example.bookmyshow.dtos;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RateMovieRequestDTO {
    private long userId;
    private long movieId;
    private int rating;
}
