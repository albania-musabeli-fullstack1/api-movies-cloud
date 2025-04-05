package com.musabeli.api_movies_cloud.services;

import com.musabeli.api_movies_cloud.dtos.ErrorMessageResponseDto;
import com.musabeli.api_movies_cloud.entities.Movie;
import com.musabeli.api_movies_cloud.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService{

    @Autowired
    private MovieRepository movieRepository;

    private Object findMovieById(Long id){
        Optional<Movie> movie = this.movieRepository.findById(id);

        if (movie.isEmpty()){
            return new ErrorMessageResponseDto("No se encontró la película con id " + id);
        }
        return movie;
    }

    @Override
    public List<Movie> getAllMovies() {
        return this.movieRepository.findAll();
    }

    @Override
    public Object getMovieById(Long id) {
        return this.findMovieById(id);
    }

    @Override
    public Movie createMovie(Movie movie) {
        return this.movieRepository.save(movie);
    }

    @Override
    public Object updateMovie(Long id, Movie movie) {
        Object objeto = this.findMovieById(id);

        if (objeto instanceof Optional){
            movie.setId(id);
            return this.movieRepository.save(movie);
        }
        return objeto;
    }

    @Override
    public Object deleteMovie(Long id) {
        Object objeto = this.findMovieById(id);

        if (objeto instanceof Optional){
            this.movieRepository.deleteById(id);
        }
        return objeto;
    }
}
