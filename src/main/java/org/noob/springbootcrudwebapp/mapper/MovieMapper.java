package org.noob.springbootcrudwebapp.mapper;

import org.noob.springbootcrudwebapp.dto.*;
import org.noob.springbootcrudwebapp.entity.Movie;
import org.springframework.stereotype.Component;
import java.util.Objects;

@Component
public class MovieMapper {

    // CreateMovieDTO → Movie
    public Movie toEntity(CreateMovieDTO dto) {
        Objects.requireNonNull(dto, "CreateMovieDTO must not be null");

        Movie movie = new Movie();
        movie.setTitle(dto.getTitle());
        movie.setDescription(dto.getDescription());
        movie.setReleaseDate(dto.getReleaseDate());
        movie.setDirector(dto.getDirector());
        movie.setDuration(dto.getDuration());
        return movie;
    }

    // Movie → MovieDTO
    public MovieDTO toDTO(Movie movie) {
        Objects.requireNonNull(movie, "Movie must not be null");

        MovieDTO dto = new MovieDTO();
        dto.setId(movie.getId());
        dto.setTitle(movie.getTitle());
        dto.setDescription(movie.getDescription());
        dto.setReleaseDate(movie.getReleaseDate());
        dto.setDirector(movie.getDirector());
        dto.setDuration(movie.getDuration());
        return dto;
    }

    // UpdateMovieDTO → uppdatera Movie
    public void updateEntity(Movie movie, UpdateMovieDTO dto) {
        Objects.requireNonNull(movie, "Movie must not be null");
        Objects.requireNonNull(dto, "UpdateMovieDTO must not be null");

        if (dto.getId() == null) {
            throw new IllegalArgumentException("UpdateMovieDTO id must not be null");
        }
        if (!dto.getId().equals(movie.getId())) {
            throw new IllegalArgumentException(
                    "UpdateMovieDTO id (" + dto.getId() + ") does not match Movie id (" + movie.getId() + ")"
            );
        }

        movie.setTitle(dto.getTitle());
        movie.setDescription(dto.getDescription());
        movie.setReleaseDate(dto.getReleaseDate());
        movie.setDirector(dto.getDirector());
        movie.setDuration(dto.getDuration());
    }


}
