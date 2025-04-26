package com.musabeli.api_movies_cloud.services;

import com.musabeli.api_movies_cloud.dtos.CreateMovieDto;
import com.musabeli.api_movies_cloud.dtos.UpdateMovieDto;
import com.musabeli.api_movies_cloud.entities.Movie;
import com.musabeli.api_movies_cloud.exceptions.ResourceNotFoundException;
import com.musabeli.api_movies_cloud.mapper.MovieMapper;
import com.musabeli.api_movies_cloud.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class MovieServiceImpl implements MovieService{

    @Autowired
    private MovieRepository movieRepository;


    private Movie findMovieById(Long id){
        Optional<Movie> movie = this.movieRepository.findById(id);

        if (movie.isPresent()){
            return movie.get();
        }
        else {
            throw new ResourceNotFoundException("No existen registros de la pelicula con id " + id);
        }
    }

    @Override
    public List<Movie> getAllMovies() {
        return this.movieRepository.findAll();
    }

    @Override
    public Movie getMovieById(Long id) {
        return this.findMovieById(id);
    }

    @Override
    public Movie createMovie(CreateMovieDto movieDto) {
        Movie movie = MovieMapper.fromCreateMovie(movieDto);
        // guardar en bbdd
        return this.movieRepository.save(movie);
    }

    @Override
    public Movie updateMovie(Long id, UpdateMovieDto updateMovieDto) {

        Movie updateMovie = this.findMovieById(id);
        if (updateMovieDto.getTitle() != null){
            updateMovie.setTitle(updateMovieDto.getTitle());
        }
        if (updateMovieDto.getYear() != null){
            updateMovie.setYear(updateMovieDto.getYear());
        }
        if (updateMovieDto.getDirector() != null){
            updateMovie.setDirector(updateMovieDto.getDirector());
        }
        if (updateMovieDto.getGenre() != null){
            updateMovie.setGenre(updateMovieDto.getGenre());
        }
        if (updateMovieDto.getSynopsis() != null){
            updateMovie.setSynopsis(updateMovieDto.getSynopsis());
        }
        return this.movieRepository.save(updateMovie);
    }


    @Override
    public Movie deleteMovie(Long id) {
        Movie movie = this.findMovieById(id);

        this.movieRepository.deleteById(id);
        return movie;
    }
}
