package org.noob.springbootcrudwebapp.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.noob.springbootcrudwebapp.dto.CreateMovieDTO;
import org.noob.springbootcrudwebapp.dto.MovieDTO;
import org.noob.springbootcrudwebapp.dto.UpdateMovieDTO;
import org.noob.springbootcrudwebapp.entity.Movie;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class MovieMapperTest {

    private MovieMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = new MovieMapper();
    }

    // toEntity

    @Test
    void toEntity_mapsAllFields() {
        CreateMovieDTO dto = new CreateMovieDTO();
        dto.setTitle("Inception");
        dto.setDescription("A mind-bending thriller");
        dto.setDirector("Christopher Nolan");
        dto.setReleaseDate(LocalDate.of(2010, 7, 16));
        dto.setDuration(148);

        Movie movie = mapper.toEntity(dto);

        assertEquals("Inception", movie.getTitle());
        assertEquals("A mind-bending thriller", movie.getDescription());
        assertEquals("Christopher Nolan", movie.getDirector());
        assertEquals(LocalDate.of(2010, 7, 16), movie.getReleaseDate());
        assertEquals(148, movie.getDuration());
    }

    @Test
    void toEntity_throwsWhenDtoIsNull() {
        assertThrows(NullPointerException.class, () -> mapper.toEntity(null));
    }

    // toDTO

    @Test
    void toDTO_mapsAllFields() {
        Movie movie = new Movie();
        movie.setId(1L);
        movie.setTitle("Inception");
        movie.setDescription("A mind-bending thriller");
        movie.setDirector("Christopher Nolan");
        movie.setReleaseDate(LocalDate.of(2010, 7, 16));
        movie.setDuration(148);

        MovieDTO dto = mapper.toDTO(movie);

        assertEquals(1L, dto.getId());
        assertEquals("Inception", dto.getTitle());
        assertEquals("A mind-bending thriller", dto.getDescription());
        assertEquals("Christopher Nolan", dto.getDirector());
        assertEquals(LocalDate.of(2010, 7, 16), dto.getReleaseDate());
        assertEquals(148, dto.getDuration());
    }

    @Test
    void toDTO_throwsWhenMovieIsNull() {
        assertThrows(NullPointerException.class, () -> mapper.toDTO(null));
    }

    // UPDATE ENTITY

    @Test
    void updateEntity_updatesAllFields() {
        Movie movie = new Movie();
        movie.setId(1L);
        movie.setTitle("Old Title");
        movie.setDescription("Old description");
        movie.setDirector("Old Director");
        movie.setReleaseDate(LocalDate.of(2000, 1, 1));
        movie.setDuration(90);

        UpdateMovieDTO dto = new UpdateMovieDTO();
        dto.setId(1L);
        dto.setTitle("Inception");
        dto.setDescription("A mind-bending thriller");
        dto.setDirector("Christopher Nolan");
        dto.setReleaseDate(LocalDate.of(2010, 7, 16));
        dto.setDuration(148);

        mapper.updateEntity(movie, dto);

        assertEquals(1L, movie.getId());
        assertEquals("Inception", movie.getTitle());
        assertEquals("A mind-bending thriller", movie.getDescription());
        assertEquals("Christopher Nolan", movie.getDirector());
        assertEquals(LocalDate.of(2010, 7, 16), movie.getReleaseDate());
        assertEquals(148, movie.getDuration());
    }

    @Test
    void updateEntity_throwsWhenIdsMismatch() {
        Movie movie = new Movie();
        movie.setId(1L);

        UpdateMovieDTO dto = new UpdateMovieDTO();
        dto.setId(99L);

        assertThrows(IllegalArgumentException.class, () -> mapper.updateEntity(movie, dto));
    }

    @Test
    void updateEntity_throwsWhenDtoIdIsNull() {
        Movie movie = new Movie();
        movie.setId(1L);

        UpdateMovieDTO dto = new UpdateMovieDTO();
        dto.setId(null);

        assertThrows(IllegalArgumentException.class, () -> mapper.updateEntity(movie, dto));
    }

    @Test
    void updateEntity_throwsWhenMovieIsNull() {
        UpdateMovieDTO dto = new UpdateMovieDTO();
        dto.setId(1L);

        assertThrows(NullPointerException.class, () -> mapper.updateEntity(null, dto));
    }

    @Test
    void updateEntity_throwsWhenDtoIsNull() {
        Movie movie = new Movie();
        movie.setId(1L);

        assertThrows(NullPointerException.class, () -> mapper.updateEntity(movie, null));
    }
}
