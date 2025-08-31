package org.example.bookmyshow.dtos;

import lombok.Data;


@Data
public class GetAverageMovieResponseDTO {
    private ResponseStatus responseStatus;
    private double averageRating;
}
