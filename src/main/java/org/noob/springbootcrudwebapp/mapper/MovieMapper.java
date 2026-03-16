package org.noob.springbootcrudwebapp.mapper;

import org.noob.springbootcrudwebapp.dto.*;
import org.noob.springbootcrudwebapp.entity.Movie;
import org.springframework.stereotype.Component;

@Component
public class MovieMapper {

    // CreateMovieDTO → Movie
    public Movie toEntity(CreateMovieDTO dto) {
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
        movie.setTitle(dto.getTitle());
        movie.setDescription(dto.getDescription());
        movie.setReleaseDate(dto.getReleaseDate());
        movie.setDirector(dto.getDirector());
        movie.setDuration(dto.getDuration());
    }

}
