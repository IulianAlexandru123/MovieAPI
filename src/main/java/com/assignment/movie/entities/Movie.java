package com.assignment.movie.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "movies")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Movie implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private UUID id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "genre", nullable = false)
    private Genre genre;

    @ElementCollection(fetch = FetchType.EAGER)
    @Column(name = "tags", nullable = false)
    private List<String> tags;

    @Column(name = "length", nullable = false)
    private Long length;

    @Column(name = "dateReleased", nullable = false)
    private Date dateReleased;

    @Column(name = "dateAvailableUntil", nullable = false)
    private Date dateAvailableUntil;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> pictureUrls;
    private String metaTitle;
    private String metaDescription;
}