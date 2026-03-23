package org.noob.springbootcrudwebapp.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(name = "uk_movie_title_release_date", columnNames = {"title", "release_date"}))
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Titel får inte vara tom")
    private String title;

    @NotBlank(message = "Beskrivning får inte vara tom")
    private String description;

    @PastOrPresent(message = "Utgivningsdatum får inte vara i framtiden")
    private LocalDate releaseDate;

    @NotBlank(message = "Regissör får inte vara tom")
    private String director;

    @Min(value = 1, message = "Speltid måste vara minst 1 minut")
    private int duration;

    public Movie() {
        // Required by JPA
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
