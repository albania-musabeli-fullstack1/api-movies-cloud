package com.musabeli.api_movies_cloud.controllers;

import com.musabeli.api_movies_cloud.dtos.CreateMovieDto;
import com.musabeli.api_movies_cloud.dtos.UpdateMovieDto;
import com.musabeli.api_movies_cloud.entities.Movie;
import com.musabeli.api_movies_cloud.services.MovieService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
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
    public ResponseEntity<Movie> createMovie(@RequestBody CreateMovieDto movieDto){
        Movie newMovie = this.movieService.createMovie(movieDto);
        newMovie.add(WebMvcLinkBuilder.linkTo(
                WebMvcLinkBuilder.methodOn(MovieController.class).getMovieById(newMovie.getId())).withSelfRel()
        );
        newMovie.add(WebMvcLinkBuilder.linkTo(
                WebMvcLinkBuilder.methodOn(MovieController.class).getAllMovies()).withRel(IanaLinkRelations.COLLECTION)
        );

        return ResponseEntity.created(
                WebMvcLinkBuilder.linkTo(
                        WebMvcLinkBuilder.methodOn(MovieController.class).getMovieById(newMovie.getId())
                ).toUri()
        ).body(newMovie);
    };

    @GetMapping("/getAllMovies")
    public ResponseEntity<List<Movie>> getAllMovies(){
        List<Movie> movieList = this.movieService.getAllMovies();

        for (Movie movie:movieList){
            movie.add(WebMvcLinkBuilder.linkTo(
                    WebMvcLinkBuilder.methodOn(MovieController.class).getMovieById(movie.getId())).withSelfRel()
            );
            movie.add(WebMvcLinkBuilder.linkTo(
                    WebMvcLinkBuilder.methodOn(MovieController.class).getAllMovies()).withRel(IanaLinkRelations.COLLECTION)
            );
        }
        CollectionModel<Movie> model = CollectionModel.of(movieList);
        model.add(WebMvcLinkBuilder.linkTo(
                WebMvcLinkBuilder.methodOn(MovieController.class).getAllMovies()).withSelfRel());

        return ResponseEntity.status(HttpStatus.OK).body(movieList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Long id){
        Movie movie = this.movieService.getMovieById(id);
        movie.add(WebMvcLinkBuilder.linkTo(
                WebMvcLinkBuilder.methodOn(MovieController.class).getMovieById(movie.getId())).withSelfRel()
        );
        movie.add(WebMvcLinkBuilder.linkTo(
                WebMvcLinkBuilder.methodOn(MovieController.class).getAllMovies()).withRel(IanaLinkRelations.COLLECTION)
        );
        return ResponseEntity.status(HttpStatus.OK).body(movie);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable Long id, @Valid @RequestBody UpdateMovieDto movieDto){
        Movie movie = this.movieService.updateMovie(id, movieDto);
        movie.add(WebMvcLinkBuilder.linkTo(
                WebMvcLinkBuilder.methodOn(MovieController.class).getMovieById(movie.getId())).withSelfRel()
        );
        movie.add(WebMvcLinkBuilder.linkTo(
                WebMvcLinkBuilder.methodOn(MovieController.class).getAllMovies()).withRel(IanaLinkRelations.COLLECTION)
        );
        return ResponseEntity.status(HttpStatus.OK).body(movie);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteMovie(@PathVariable Long id){
        Movie movie = this.movieService.deleteMovie(id);
        return ResponseEntity.status(HttpStatus.OK).body(movie);
    }


}
