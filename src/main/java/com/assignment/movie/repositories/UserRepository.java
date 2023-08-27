package com.assignment.movie.repositories;

import com.assignment.movie.entities.Genre;
import com.assignment.movie.entities.Movie;
import com.assignment.movie.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByEmail(String email);

    Optional<User> findByPhoneNumber(String phone);
}
