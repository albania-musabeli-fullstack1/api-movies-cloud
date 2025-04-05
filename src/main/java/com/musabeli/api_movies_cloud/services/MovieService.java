package com.musabeli.api_movies_cloud.services;


import com.musabeli.api_movies_cloud.entities.Movie;

import java.util.List;

public interface MovieService {

    List<Movie> getAllMovies();

    Object getMovieById(Long id);

    Movie createMovie(Movie movie);

    Object updateMovie(Long id, Movie movie);

    Object deleteMovie(Long id);
}
