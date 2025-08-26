package org.example.bookmyshow.services;

import java.util.List;
import java.util.Optional;

import org.example.bookmyshow.exceptions.MovieNotFoundException;
import org.example.bookmyshow.exceptions.UserNotFoundException;
import org.example.bookmyshow.models.Movie;
import org.example.bookmyshow.models.Rating;
import org.example.bookmyshow.models.User;
import org.example.bookmyshow.repositories.MovieRepository;
import org.example.bookmyshow.repositories.RatingRepository;
import org.example.bookmyshow.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class RatingServiceImpl implements RatingsService {
    private final RatingRepository ratingRepository;
    private final MovieRepository movieRepository;
    private final UserRepository userRepository;

    public RatingServiceImpl(RatingRepository ratingRepository,
                             MovieRepository movieRepository,
                             UserRepository userRepository) {
        this.movieRepository = movieRepository;
        this.ratingRepository = ratingRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Rating rateMovie(long userId, long movieId, int rating) throws UserNotFoundException, MovieNotFoundException {
        User user = this.userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User not Found"));
        Movie movie = this.movieRepository.findById(movieId).orElseThrow(() -> new MovieNotFoundException("Movie not found"));
        Optional<Rating> optionalRating = this.ratingRepository.findByMovieAndUser(movie, user);
        Rating rate;
        if (optionalRating.isPresent()) {
            rate = optionalRating.get();
            rate.setRating(rating);
        } else {
            rate = new Rating();
            rate.setRating(rating);
            rate.setMovie(movie);
            rate.setUser(user);
        }
        return ratingRepository.save(rate);
    }


    @Override
    public double getAverageRating(long movieId) throws MovieNotFoundException {
        Movie movie = this.movieRepository.findById(movieId).orElseThrow(() -> new MovieNotFoundException("Movie not found"));
        List<Rating> ratings = this.ratingRepository.findByMovie(movie);
        return ratings.stream()
                .mapToInt(Rating::getRating)
                .average()
                .orElse(0.0);
    }
}
