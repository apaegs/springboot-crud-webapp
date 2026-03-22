package org.noob.springbootcrudwebapp.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.noob.springbootcrudwebapp.dto.*;
import org.noob.springbootcrudwebapp.entity.Movie;
import org.noob.springbootcrudwebapp.exception.ResourceNotFoundException;
import org.noob.springbootcrudwebapp.mapper.MovieMapper;
import org.noob.springbootcrudwebapp.repository.MovieRepository;
import org.springframework.data.domain.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MovieServiceTest {

    @Mock
    private MovieRepository repository;

    @Mock
    private MovieMapper mapper;

    @InjectMocks
    private MovieService service;

    private Movie movie;
    private MovieDTO movieDTO;

    @BeforeEach
    void setUp() {
        movie = new Movie();
        movie.setId(1L);
        movie.setTitle("Inception");
        movie.setDescription("A mind-bending thriller");
        movie.setDirector("Christopher Nolan");
        movie.setReleaseDate(LocalDate.of(2010, 7, 16));
        movie.setDuration(148);

        movieDTO = new MovieDTO();
        movieDTO.setId(1L);
        movieDTO.setTitle("Inception");
        movieDTO.setDescription("A mind-bending thriller");
        movieDTO.setDirector("Christopher Nolan");
        movieDTO.setReleaseDate(LocalDate.of(2010, 7, 16));
        movieDTO.setDuration(148);
    }

    // CREATE

    @Test
    void create_savesAndReturnsDTO() {
        CreateMovieDTO createDTO = new CreateMovieDTO();
        createDTO.setTitle("Inception");

        when(mapper.toEntity(createDTO)).thenReturn(movie);
        when(repository.save(movie)).thenReturn(movie);
        when(mapper.toDTO(movie)).thenReturn(movieDTO);

        MovieDTO result = service.create(createDTO);

        assertEquals(movieDTO, result);
        verify(repository).save(movie);
    }

    @Test
    void create_throwsWhenDtoIsNull() {
        assertThrows(NullPointerException.class, () -> service.create(null));
    }

    // FIND BY ID

    @Test
    void findById_returnsDTO_whenMovieExists() {
        when(repository.findById(1L)).thenReturn(Optional.of(movie));
        when(mapper.toDTO(movie)).thenReturn(movieDTO);

        MovieDTO result = service.findById(1L);

        assertEquals(movieDTO, result);
    }

    @Test
    void findById_throwsResourceNotFoundException_whenMovieNotFound() {
        when(repository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> service.findById(99L));
    }

    // UPDATE

    @Test
    void update_updatesAndReturnsDTO() {
        UpdateMovieDTO updateDTO = new UpdateMovieDTO();
        updateDTO.setId(1L);
        updateDTO.setTitle("Inception Updated");

        when(repository.findById(1L)).thenReturn(Optional.of(movie));
        doNothing().when(mapper).updateEntity(movie, updateDTO);
        when(mapper.toDTO(movie)).thenReturn(movieDTO);

        MovieDTO result = service.update(updateDTO);

        assertEquals(movieDTO, result);
        verify(mapper).updateEntity(movie, updateDTO);
    }

    @Test
    void update_throwsResourceNotFoundException() {
        UpdateMovieDTO updateDTO = new UpdateMovieDTO();
        updateDTO.setId(99L);

        when(repository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> service.update(updateDTO));
    }

    @Test
    void update_throwsWhenDtoIsNull() {
        assertThrows(NullPointerException.class, () -> service.update(null));
    }

    // DELETE

    @Test
    void delete_deleteMovie_whenExists() {
        when(repository.findById(1L)).thenReturn(Optional.of(movie));

        service.delete(1L);

        verify(repository).delete(movie);
    }

    @Test
    void delete_throwsResourceNotFoundException_whenMovieNotFound() {
        when(repository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> service.delete(99L));
    }

    @Test
    void delete_throwsWhenIdIsNull() {
        assertThrows(NullPointerException.class, () -> service.delete(null));
    }

    // FIND PAGINATED

    @Test
    void findPaginated_returnsMoviePageDTO() {
        Pageable pageable = PageRequest.of(0, 9);
        Page<Movie> page = new PageImpl<>(List.of(movie), pageable, 1);

        when(repository.findAll(pageable)).thenReturn(page);
        when(mapper.toDTO(movie)).thenReturn(movieDTO);

        MoviePageDTO result = service.findPaginated(0, 9);

        assertEquals(1, result.getTotalElements());
        assertEquals(1, result.getMovies().size());
        assertEquals(movieDTO, result.getMovies().get(0));
    }

    @Test
    void findPaginated_throwsResourceNotFoundException_whenPageOutOfBounds() {
        Pageable pageable = PageRequest.of(5, 9);
        Page<Movie> page = new PageImpl<>(List.of(), pageable, 1);

        when(repository.findAll(pageable)).thenReturn(page);

        assertThrows(ResourceNotFoundException.class, () -> service.findPaginated(5, 9));
    }

    // SEARCH PAGINATED

    @Test
    void searchPaginated_returnsFilteredResults() {
        MovieFilterDTO filter = new MovieFilterDTO();
        filter.setTitle("Inception");

        Pageable pageable = PageRequest.of(0, 9);
        Page<Movie> page = new PageImpl<>(List.of(movie), pageable, 1);

        when(repository.searchPaginated(
                eq("Inception"), isNull(), isNull(), isNull(), isNull(), isNull(), eq(pageable)
        )).thenReturn(page);
        when(mapper.toDTO(movie)).thenReturn(movieDTO);

        MoviePageDTO result = service.searchPaginated(filter, 0, 9);

        assertEquals(1, result.getTotalElements());
        assertEquals(movieDTO, result.getMovies().get(0));
    }

    @Test
    void searchPaginated_treatsBlankTitleAsNull() {
        MovieFilterDTO filter = new MovieFilterDTO();
        filter.setTitle("   ");

        Pageable pageable = PageRequest.of(0, 9);
        Page<Movie> page = new PageImpl<>(List.of(), pageable, 0);

        when(repository.searchPaginated(
                isNull(), isNull(), isNull(), isNull(), isNull(), isNull(), eq(pageable)
        )).thenReturn(page);

        MoviePageDTO result = service.searchPaginated(filter, 0, 9);

        assertEquals(0, result.getTotalElements());
        verify(repository).searchPaginated(
                isNull(), isNull(), isNull(), isNull(), isNull(), isNull(), eq(pageable)
        );
    }
}
