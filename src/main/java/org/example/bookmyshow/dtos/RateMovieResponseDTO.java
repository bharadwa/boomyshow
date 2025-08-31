package org.example.bookmyshow.dtos;

import lombok.Data;
import org.example.bookmyshow.models.Rating;

@Data
public class RateMovieResponseDTO {
    private ResponseStatus responseStatus;
    private Rating rating;
}
