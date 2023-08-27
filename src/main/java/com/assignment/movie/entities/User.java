package com.assignment.movie.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private UUID id;

    @Column(name = "email", nullable = false, unique = true)
    @Email(message = "Invalid email")
    private String email;

    @Column(name = "phone", nullable = false, unique = true)
    @Pattern(regexp="(^$|[0-9]{10})", message = "Invalid phone number")
    private String phoneNumber;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Movie> favoriteMovies;

    @ElementCollection(targetClass = Genre.class, fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "user_favorite_categories", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "favorite_category")
    private Set<Genre> favoriteCategories;

    @Enumerated(EnumType.STRING)
    private WebsiteTheme websiteTheme;
}