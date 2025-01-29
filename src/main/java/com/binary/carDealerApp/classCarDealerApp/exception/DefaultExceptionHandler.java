package com.binary.carDealerApp.classCarDealerApp.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class DefaultExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(DefaultExceptionHandler.class);

    @ExceptionHandler(CarNotFoundException.class)
    private ResponseEntity<ApiError> exceptionHandler(
            CarNotFoundException e,
            HttpServletRequest request
    ) {
        ApiError apiError = new ApiError(
                e.getMessage(),
                HttpStatus.NOT_FOUND.value(),
                request.getRequestURI(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    private ResponseEntity<ApiError> exceptionHandler(
            IllegalArgumentException e,
            HttpServletRequest request
    ) {
        ApiError apiError = new ApiError(
                e.getMessage(),
                HttpStatus.BAD_REQUEST.value(),
                request.getRequestURI(),
                LocalDateTime.now()
        );
        log.info("apiError " + apiError);
        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    private ResponseEntity<ApiError> exceptionHandler(
            Exception e,
            HttpServletRequest request
    ) {
        ApiError apiError = new ApiError(
                e.getMessage(),
                HttpStatus.BAD_REQUEST.value(),
                request.getRequestURI(),
                LocalDateTime.now()
        );

        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }
}
