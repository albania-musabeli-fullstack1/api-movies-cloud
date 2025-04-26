package com.musabeli.api_movies_cloud.mapper;

import com.musabeli.api_movies_cloud.dtos.CreateMovieDto;
import com.musabeli.api_movies_cloud.entities.Movie;

public class MovieMapper {

    public static Movie fromCreateMovie(CreateMovieDto dto){
        return Movie.builder()
                .title(dto.getTitle())
                .year(dto.getYear())
                .director(dto.getDirector())
                .genre(dto.getGenre())
                .synopsis(dto.getSynopsis())
                .build();
    }
}
