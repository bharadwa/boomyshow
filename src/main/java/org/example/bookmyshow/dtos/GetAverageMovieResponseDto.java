package org.example.bookmyshow.dtos;

import lombok.Data;


@Data
public class GetAverageMovieResponseDto {
    private ResponseStatus responseStatus;
    private double averageRating;
}
