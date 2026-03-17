package org.noob.springbootcrudwebapp.controller;

import jakarta.validation.Valid;
import org.noob.springbootcrudwebapp.dto.CreateMovieDTO;
import org.noob.springbootcrudwebapp.dto.MovieDTO;
import org.noob.springbootcrudwebapp.dto.UpdateMovieDTO;
import org.noob.springbootcrudwebapp.service.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/movies")
public class MovieController {

    private final MovieService service;

    public MovieController(MovieService service) {
        this.service = service;
    }

    // LIST ALL
    @GetMapping
    public String listMovies(Model model) {
        model.addAttribute("movies", service.findAll());
        return "movies/list";
    }

    // FORM
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("movie", new CreateMovieDTO());
        model.addAttribute("errors", null);
        return "movies/create";
    }

    // CREATE
    @PostMapping
    public String createMovie(@Valid @ModelAttribute("movie") CreateMovieDTO dto,
                              BindingResult result,
                              Model model) {

        if (result.hasErrors()) {
            model.addAttribute("movie", dto);
            model.addAttribute("errors", result);
            return "movies/create";
        }

        service.create(dto);
        return "redirect:/movies";
    }

    // EDIT FORM
    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model) {
        // GlobalExceptionHandler tar hand om IllegalArgumentException om filmen saknas
        MovieDTO movieDTO = service.findById(id);

        UpdateMovieDTO updateDTO = new UpdateMovieDTO();
        updateDTO.setId(movieDTO.getId());
        updateDTO.setTitle(movieDTO.getTitle());
        updateDTO.setDescription(movieDTO.getDescription());
        updateDTO.setDirector(movieDTO.getDirector());
        updateDTO.setReleaseDate(movieDTO.getReleaseDate());
        updateDTO.setDuration(movieDTO.getDuration());

        model.addAttribute("movie", updateDTO);
        model.addAttribute("errors", null);
        return "movies/edit";
    }

    // UPDATE POST
    @PostMapping("/{id}/edit")
    public String updateMovie(@PathVariable Long id,
                              @Valid @ModelAttribute("movie") UpdateMovieDTO dto,
                              BindingResult result,
                              Model model) {

        if (dto.getId() != null && !id.equals(dto.getId())) {
            result.rejectValue("id", "mismatch", "Path id does not match form id");
        }

        if (result.hasErrors()) {
            model.addAttribute("movie", dto);
            model.addAttribute("errors", result);
            return "movies/edit";
        }

        dto.setId(id);
        service.update(dto); // IllegalArgumentException → GlobalExceptionHandler
        return "redirect:/movies";
    }

    // DELETE
    @PostMapping("/{id}/delete")
    public String deleteMovie(@PathVariable Long id) {
        service.delete(id); // IllegalArgumentException → GlobalExceptionHandler
        return "redirect:/movies";
    }
}
