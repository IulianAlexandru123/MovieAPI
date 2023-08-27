package com.assignment.movie.repositories;

import com.assignment.movie.entities.Genre;
import com.assignment.movie.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MovieRepository  extends JpaRepository<Movie, UUID> {
    Optional<List<Movie>> findByGenre(Genre genre);

    Optional<List<Movie>> findByTagsContaining(String tag);
}
