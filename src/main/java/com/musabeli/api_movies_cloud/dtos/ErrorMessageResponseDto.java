package com.musabeli.api_movies_cloud.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorMessageResponseDto {
    private String message;
}
