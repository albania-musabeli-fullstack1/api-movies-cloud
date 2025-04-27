package com.musabeli.api_movies_cloud.dtos;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateMovieDto {

    @Size(min = 2, max = 20, message = "El título de la película debe tener entre 2 y 20 caracteres")
    private String title;

    private Integer year;

    private String director;

    private String genre;

    private String synopsis;
}