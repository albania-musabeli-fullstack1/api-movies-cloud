package com.musabeli.api_movies_cloud.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "movie")
public class Movie extends RepresentationModel<Movie> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private int year;

    @Column(nullable = false)
    private String director;

    @Column(nullable = false)
    private String genre;

    @Column(nullable = false)
    private String synopsis;

}
