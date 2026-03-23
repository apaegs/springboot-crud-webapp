package org.noob.springbootcrudwebapp.dto;

import jakarta.validation.constraints.*;
import java.time.LocalDate;

public class UpdateMovieDTO {

    @NotNull(message = "ID saknas")
    @Positive(message = "ID måste vara positivt")
    private Long id;

    @NotBlank
    private String title;

    @NotBlank
    private String description;

    @PastOrPresent
    private LocalDate releaseDate;

    @NotBlank
    private String director;

    @Min(1)
    private int duration;

    public UpdateMovieDTO() {
        // Required for Spring MVC data binding
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
