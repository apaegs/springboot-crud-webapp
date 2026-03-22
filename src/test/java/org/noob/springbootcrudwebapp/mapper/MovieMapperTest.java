package org.noob.springbootcrudwebapp.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.noob.springbootcrudwebapp.dto.CreateMovieDTO;
import org.noob.springbootcrudwebapp.dto.MovieDTO;
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



}
