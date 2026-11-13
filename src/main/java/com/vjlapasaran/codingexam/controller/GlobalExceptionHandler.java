package com.vjlapasaran.codingexam.controller;

import com.vjlapasaran.codingexam.dto.ApiErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<ApiErrorResponse> handleResponseStatusException(ResponseStatusException ex) {

        int statusCode = ex.getStatusCode().value();

        String description;

        if(statusCode == 404) {
            description = "Customer not found";
        }
        else if(statusCode == 400) {
            description = "Invalid Customer number";
        }
        else {
            description = "request failed!";
        }

        ApiErrorResponse error = new ApiErrorResponse(
                statusCode,
                description
        );

        return ResponseEntity
                .status(statusCode)
                .body(error);
    }
}
