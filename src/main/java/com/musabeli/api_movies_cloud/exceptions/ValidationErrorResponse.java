package com.musabeli.api_movies_cloud.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ValidationErrorResponse {

    private String field;
    private String message;
    private String rejectedValue;
}
