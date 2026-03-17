package org.noob.springbootcrudwebapp.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public String handleNotFound(IllegalArgumentException ex, Model model) {
        model.addAttribute("errorMessage", ex.getMessage() != null ? ex.getMessage() : "Movie not found.");
        return "movies/not-found";
    }
}
