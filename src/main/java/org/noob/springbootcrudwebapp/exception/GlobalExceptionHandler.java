package org.noob.springbootcrudwebapp.exception;

import jakarta.validation.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleNotFound(ResourceNotFoundException ex, Model model) {
        model.addAttribute("errorMessage", ex.getMessage());
        return "movies/not-found";
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleConstraintViolation(ConstraintViolationException ex, Model model) {
        model.addAttribute("errorMessage", "Invalid request: " + ex.getMessage());
        return "movies/bad-request";
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleIllegalArgument(IllegalArgumentException ex, Model model) {
        model.addAttribute("errorMessage", "Invalid request: " + ex.getMessage());
        return "movies/bad-request";
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public String handleDuplicateEntry(DataIntegrityViolationException ex, Model model) {
        Throwable cause = ex.getRootCause();
        String message = (cause != null && cause.getMessage() != null) ? cause.getMessage().toLowerCase() : "";

        if (message.contains("uk_movie_title_release_date")) {
            model.addAttribute("errorMessage", "A movie with that title and release date already exists.");
        } else {
            model.addAttribute("errorMessage", "Database error: request could not be completed.");
        }

        return "movies/bad-request";
    }
}
