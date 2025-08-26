package org.example.bookmyshow.repositories;

import org.example.bookmyshow.models.Movie;
import org.example.bookmyshow.models.Rating;
import org.example.bookmyshow.models.User;
import org.hibernate.boot.archive.internal.JarProtocolArchiveDescriptor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {

    @Override
    Optional<Rating> findById(Long aLong);

    Optional<Rating> findByMovieAndUser(Movie movie, User user);

    Rating save(Rating rating);

    List<Rating> findByMovie(Movie movie);
}
