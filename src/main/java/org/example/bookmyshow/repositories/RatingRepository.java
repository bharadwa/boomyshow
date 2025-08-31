package org.example.bookmyshow.repositories;

import java.util.List;
import java.util.Optional;

import org.example.bookmyshow.models.Movie;
import org.example.bookmyshow.models.Rating;
import org.example.bookmyshow.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {

    @Override
    Optional<Rating> findById(Long ratingId);

    Optional<Rating> findByMovieAndUser(Movie movie, User user);

    Rating save(Rating rating);

    List<Rating> findByMovie(Movie movie);
}
