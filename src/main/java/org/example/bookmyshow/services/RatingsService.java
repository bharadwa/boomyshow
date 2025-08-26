package org.example.bookmyshow.services;


import org.example.bookmyshow.exceptions.MovieNotFoundException;
import org.example.bookmyshow.exceptions.UserNotFoundException;
import org.example.bookmyshow.models.Rating;

public interface RatingsService {

    public Rating rateMovie(long userId, long movieId, int rating) throws UserNotFoundException, MovieNotFoundException;

    public double getAverageRating(long movieId) throws MovieNotFoundException;
}
