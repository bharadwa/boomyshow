package org.example.bookmyshow.controllers;

import org.example.bookmyshow.dtos.RateMovieRequestDTO;
import org.example.bookmyshow.dtos.RateMovieResponseDTO;
import org.example.bookmyshow.dtos.ResponseStatus;
import org.example.bookmyshow.exceptions.MovieNotFoundException;
import org.example.bookmyshow.exceptions.UserNotFoundException;
import org.example.bookmyshow.services.RatingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/ratings")
@RestController
public class RatingsRestController {


    private final RatingsService ratingService;

    @Autowired
    public RatingsRestController(RatingsService ratingService) {
        this.ratingService=ratingService;
    }

    @PostMapping("/rate")
    public RateMovieResponseDTO rateMovie(@RequestBody RateMovieRequestDTO requestDto){
        RateMovieResponseDTO response =new RateMovieResponseDTO();
        try {
            response.setRating(this.ratingService.rateMovie(requestDto.getUserId(),requestDto.getMovieId(),requestDto.getRating()));
            response.setResponseStatus(ResponseStatus.SUCCESS);
        } catch (UserNotFoundException | MovieNotFoundException e) {
            response.setResponseStatus(ResponseStatus.FAILURE);
        }
        return response;
    }
}
