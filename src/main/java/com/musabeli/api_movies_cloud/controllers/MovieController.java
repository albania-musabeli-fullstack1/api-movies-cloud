package com.musabeli.api_movies_cloud.controllers;

import com.musabeli.api_movies_cloud.entities.Movie;
import com.musabeli.api_movies_cloud.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie){
        Movie newMovie = this.movieService.createMovie(movie);
        return ResponseEntity.status(HttpStatus.CREATED).body(newMovie);
    };

    @GetMapping("/getAllMovies")
    public ResponseEntity<List<Movie>> getAllMovies(){
        List<Movie> movieList = this.movieService.getAllMovies();
        return ResponseEntity.status(HttpStatus.OK).body(movieList);
    }

}
