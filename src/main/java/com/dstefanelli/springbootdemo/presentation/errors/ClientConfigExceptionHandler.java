package com.dstefanelli.springbootdemo.presentation.errors;

import com.dstefanelli.springbootdemo.application.exceptions.PlayerProfileNotFound;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
public class ClientConfigExceptionHandler {

    @ExceptionHandler(PlayerProfileNotFound.class)
    public ResponseEntity<ErrorResponse> handleUserNotFound(PlayerProfileNotFound ex, HttpServletRequest request) {
        ErrorResponse error = new ErrorResponse(
                Instant.now(),
                HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND.getReasonPhrase(),
                ex.getMessage(),
                request.getRequestURI()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

}