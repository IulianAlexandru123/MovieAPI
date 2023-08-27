package com.assignment.movie.services;

import com.assignment.movie.controllers.exceptions.ResourceNotFoundException;
import com.assignment.movie.entities.Genre;
import com.assignment.movie.entities.Movie;
import com.assignment.movie.entities.User;
import com.assignment.movie.repositories.MovieRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MovieService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MovieService.class);

    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> findMovies() {
       return movieRepository.findAll();
    }

    public List<Movie> findMoviesByGenre(Genre genre) {
        return movieRepository.findByGenre(genre).orElseThrow(() -> new ResourceNotFoundException("No movies found in category " + genre.toString()));
    }

    public Movie findMovieById(UUID movieId) {
        return movieRepository.findById(movieId).orElseThrow(() -> new ResourceNotFoundException("Movie not found with ID " + movieId.toString()));
    }

    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public List<Movie> getMoviesByTag(String tag) {
        return movieRepository.findByTagsContaining(tag).orElseThrow(() -> new ResourceNotFoundException("No movies found with tag " + tag));
    }

    public Movie updateMovie(UUID movieId, Movie movieUpdate) {
        Movie movie = findMovieById(movieId);
        Optional.ofNullable(movieUpdate.getTitle()).ifPresent(movie::setTitle);
        Optional.ofNullable(movieUpdate.getDescription()).ifPresent(movie::setDescription);
        Optional.ofNullable(movieUpdate.getGenre()).ifPresent(movie::setGenre);
        Optional.ofNullable(movieUpdate.getTags()).ifPresent(movie::setTags);
        Optional.ofNullable(movieUpdate.getLength()).ifPresent(movie::setLength);
        Optional.ofNullable(movieUpdate.getDateReleased()).ifPresent(movie::setDateReleased);
        Optional.ofNullable(movieUpdate.getDateAvailableUntil()).ifPresent(movie::setDateAvailableUntil);
        Optional.ofNullable(movieUpdate.getPictureUrls()).ifPresent(movie::setPictureUrls);
        Optional.ofNullable(movieUpdate.getMetaTitle()).ifPresent(movie::setMetaTitle);
        Optional.ofNullable(movieUpdate.getMetaDescription()).ifPresent(movie::setMetaDescription);
        return movieRepository.save(movie);
    }

    public void deleteMovieById(UUID movieId) {
        movieRepository.deleteById(movieId);
    }
}
