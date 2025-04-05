package com.musabeli.api_movies_cloud.controllers;

import com.musabeli.api_movies_cloud.entities.Movie;
import com.musabeli.api_movies_cloud.services.MovieService;
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
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie){
        Movie newMovie = this.movieService.createMovie(movie);
        return ResponseEntity.status(HttpStatus.CREATED).body(newMovie);
    };

    @GetMapping("/getAllMovies")
    public ResponseEntity<List<Movie>> getAllMovies(){
        List<Movie> movieList = this.movieService.getAllMovies();
        return ResponseEntity.status(HttpStatus.OK).body(movieList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getMovieById(@PathVariable Long id){
        Object objetoResponse = this.movieService.getMovieById(id);

        if (objetoResponse instanceof Optional){
            return ResponseEntity.status(HttpStatus.OK).body(objetoResponse);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(objetoResponse);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateMovie(@PathVariable Long id, @RequestBody Movie movie){
        Object objetoResponse = this.movieService.updateMovie(id, movie);

        if (objetoResponse instanceof Movie){
            return ResponseEntity.status(HttpStatus.OK).body(objetoResponse);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(objetoResponse);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteMovie(@PathVariable Long id){
        Object objetoResponse = this.movieService.deleteMovie(id);

        if (objetoResponse instanceof Optional){
            return ResponseEntity.status(HttpStatus.OK).body(objetoResponse);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(objetoResponse);
        }
    }


}
