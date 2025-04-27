package com.musabeli.api_movies_cloud.dtos;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateMovieDto {

    @NotBlank(message = "El campo título es obligatorio")
    @Size(min = 2, max = 20, message = "El título de la película debe tener entre 2 y 20 caracteres")
    private String title;

    @NotBlank(message = "El campo año es obligatorio")
    private int year;

    @NotBlank(message = "El campo director es obligatorio")
    private String director;

    @NotBlank(message = "El campo género es obligatorio")
    private String genre;

    @NotBlank(message = "El campo sinopsis es obligatorio")
    private String synopsis;
}
