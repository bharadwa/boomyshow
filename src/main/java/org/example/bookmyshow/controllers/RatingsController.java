package org.example.bookmyshow.controllers;

import org.example.bookmyshow.exceptions.MovieNotFoundException;
import org.example.bookmyshow.services.RatingsService;
import org.springframework.stereotype.Controller;
import org.example.bookmyshow.dtos.*;
import org.example.bookmyshow.exceptions.UserNotFoundException;

@Controller
public class RatingsController {

    private RatingsService ratingService;

    public RatingsController(RatingsService ratingService) {
        this.ratingService=ratingService;
    }

    public RateMovieResponseDto rateMovie(RateMovieRequestDto requestDto){
        RateMovieResponseDto response =new RateMovieResponseDto();
        try {
            response.setRating(this.ratingService.rateMovie(requestDto.getUserId(),requestDto.getMovieId(),requestDto.getRating()));
            response.setResponseStatus(ResponseStatus.SUCCESS);
        } catch (UserNotFoundException | MovieNotFoundException e) {
            response.setResponseStatus(ResponseStatus.FAILURE);
        }
        return response;
    }

    public GetAverageMovieResponseDto getAverageMovieRating(GetAverageMovieRequestDto requestDto){

        GetAverageMovieResponseDto response =new GetAverageMovieResponseDto();
        
        try {
            response.setAverageRating(this.ratingService.getAverageRating(requestDto.getMovieId()));
            response.setResponseStatus(ResponseStatus.SUCCESS);
        } catch (MovieNotFoundException e) {
            response.setResponseStatus(ResponseStatus.FAILURE);
        }

        return response;
    }
}
