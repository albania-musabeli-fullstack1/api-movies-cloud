package com.musabeli.api_movies_cloud.services;


import com.musabeli.api_movies_cloud.dtos.CreateMovieDto;
import com.musabeli.api_movies_cloud.dtos.UpdateMovieDto;
import com.musabeli.api_movies_cloud.entities.Movie;

import java.util.List;

public interface MovieService {

    Movie createMovie(CreateMovieDto movieDto);
    List<Movie> getAllMovies();
    Movie getMovieById(Long id);
    Movie updateMovie(Long id, UpdateMovieDto updateMovieDto);
    Movie deleteMovie(Long id);
}
