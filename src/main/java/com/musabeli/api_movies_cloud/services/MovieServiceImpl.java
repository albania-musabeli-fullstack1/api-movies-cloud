package com.musabeli.api_movies_cloud.services;

import com.musabeli.api_movies_cloud.entities.Movie;
import com.musabeli.api_movies_cloud.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService{

    @Autowired
    private MovieRepository movieRepository;


    @Override
    public List<Movie> getAllMovies() {
        return this.movieRepository.findAll();
    }

    @Override
    public Object getMovieById(Long id) {
        return null;
    }

    @Override
    public Movie createMovie(Movie movie) {
        return this.movieRepository.save(movie);
    }

    @Override
    public Object updateMovie(Long id, Movie movie) {
        return null;
    }

    @Override
    public Object deleteMovie(Long id, Movie movie) {
        return null;
    }
}
