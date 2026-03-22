package org.noob.springbootcrudwebapp.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.noob.springbootcrudwebapp.dto.CreateMovieDTO;
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




}
