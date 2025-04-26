package com.musabeli.api_movies_cloud.controllers;

import com.musabeli.api_movies_cloud.dtos.CreateMovieDto;
import com.musabeli.api_movies_cloud.dtos.UpdateMovieDto;
import com.musabeli.api_movies_cloud.entities.Movie;
import com.musabeli.api_movies_cloud.services.MovieService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping
    public ResponseEntity<Movie> createMovie(@RequestBody CreateMovieDto movieDto){
        Movie newMovie = this.movieService.createMovie(movieDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(newMovie);
    };

    @GetMapping("/getAllMovies")
    public ResponseEntity<List<Movie>> getAllMovies(){
        List<Movie> movieList = this.movieService.getAllMovies();
        return ResponseEntity.status(HttpStatus.OK).body(movieList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Long id){
        Movie movie = this.movieService.getMovieById(id);
        return ResponseEntity.status(HttpStatus.OK).body(movie);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable Long id, @Valid @RequestBody UpdateMovieDto movieDto){
        Movie movie = this.movieService.updateMovie(id, movieDto);
        return ResponseEntity.status(HttpStatus.OK).body(movie);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteMovie(@PathVariable Long id){
        Movie movie = this.movieService.deleteMovie(id);
        return ResponseEntity.status(HttpStatus.OK).body(movie);
    }


}
