package org.example.bookmyshow.dtos;

import lombok.Data;
import org.example.bookmyshow.models.Rating;

@Data
public class RateMovieResponseDto {
    private ResponseStatus responseStatus;
    private Rating rating;
}
