package com.assignment.movie.services;

import com.assignment.movie.controllers.exceptions.ResourceNotFoundException;
import com.assignment.movie.entities.Genre;
import com.assignment.movie.entities.Movie;
import com.assignment.movie.entities.User;
import com.assignment.movie.repositories.MovieRepository;
import com.assignment.movie.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;
    private final MovieRepository movieRepository;

    @Autowired
    public UserService(UserRepository userRepository, MovieRepository movieRepository) {
        this.userRepository = userRepository;
        this.movieRepository = movieRepository;
    }

    public List<User> findUsers() {
       return userRepository.findAll();
    }

    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(() -> new ResourceNotFoundException("User not found with email " + email));
    }

    public User findUserByPhoneNumber(String phoneNumber) {
        return userRepository.findByPhoneNumber(phoneNumber).orElseThrow(() -> new ResourceNotFoundException("User not found with phone number " + phoneNumber));
    }

    public User findUserById(UUID userId) {
        return userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found with ID " + userId.toString()));
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public User addFavoriteMovie(UUID userId, UUID movieId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        Movie movie = movieRepository.findById(movieId).orElseThrow(() -> new ResourceNotFoundException("Movie not found"));
        user.getFavoriteMovies().add(movie);
        return userRepository.save(user);
    }

    public User addFavoriteGenre(UUID userId, Genre genre) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        user.getFavoriteCategories().add(genre);
        return userRepository.save(user);
    }

    public User updateUser(UUID userId, User userUpdate) {
        User user = findUserById(userId);
        Optional.ofNullable(userUpdate.getEmail()).ifPresent(user::setEmail);
        Optional.ofNullable(userUpdate.getPhoneNumber()).ifPresent(user::setPhoneNumber);
        Optional.ofNullable(userUpdate.getFavoriteMovies()).ifPresent(user::setFavoriteMovies);
        Optional.ofNullable(userUpdate.getFavoriteCategories()).ifPresent(user::setFavoriteCategories);
        Optional.ofNullable(userUpdate.getWebsiteTheme()).ifPresent(user::setWebsiteTheme);
        return userRepository.save(user);
    }

    public void deleteUserById(UUID userId) {
        userRepository.deleteById(userId);
    }
}
