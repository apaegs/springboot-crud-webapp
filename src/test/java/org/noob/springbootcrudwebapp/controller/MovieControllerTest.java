package org.noob.springbootcrudwebapp.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.noob.springbootcrudwebapp.dto.*;
import org.noob.springbootcrudwebapp.exception.GlobalExceptionHandler;
import org.noob.springbootcrudwebapp.exception.ResourceNotFoundException;
import org.noob.springbootcrudwebapp.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = {MovieController.class, GlobalExceptionHandler.class})
class MovieControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private MovieService service;

    private MovieDTO movieDTO;
    private MoviePageDTO moviePageDTO;

    @BeforeEach
    void setUp() {
        movieDTO = new MovieDTO();
        movieDTO.setId(1L);
        movieDTO.setTitle("Inception");
        movieDTO.setDescription("A mind-bending thriller");
        movieDTO.setDirector("Christopher Nolan");
        movieDTO.setReleaseDate(LocalDate.of(2010, 7, 16));
        movieDTO.setDuration(148);

        moviePageDTO = new MoviePageDTO(List.of(movieDTO), 0, 1, 1);
    }

    // GET /movies

    @Test
    void listMovies_returnsListView_withMoviePage() throws Exception {
        when(service.findPaginated(0, 9)).thenReturn(moviePageDTO);

        mockMvc.perform(get("/movies"))
                .andExpect(status().isOk())
                .andExpect(view().name("movies/list"))
                .andExpect(model().attributeExists("moviePage"));
    }

    // GET /movies/search

    @Test
    void searchMovies_returnsSearchView_withMoviePageAndFilter() throws Exception {
        when(service.searchPaginated(any(MovieFilterDTO.class), eq(0), eq(9)))
                .thenReturn(moviePageDTO);

        mockMvc.perform(get("/movies/search"))
                .andExpect(status().isOk())
                .andExpect(view().name("movies/search"))
                .andExpect(model().attributeExists("moviePage"))
                .andExpect(model().attributeExists("filter"));
    }

    // GET /movies/new

    @Test
    void showCreateForm_returnsCreateView() throws Exception {
        mockMvc.perform(get("/movies/new"))
                .andExpect(status().isOk())
                .andExpect(view().name("movies/create"))
                .andExpect(model().attributeExists("movie"));
    }

    //POST /movies

    @Test
    void createMovie_redirectsToList_whenValid() throws Exception {
        when(service.create(any(CreateMovieDTO.class))).thenReturn(movieDTO);

        mockMvc.perform(post("/movies")
                        .param("title", "Inception")
                        .param("description", "A mind-bending thriller")
                        .param("director", "Christopher Nolan")
                        .param("duration", "148")
                        .param("releaseDate", "2010-07-16"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/movies"));
    }

    @Test
    void createMovie_returnsCreateView_whenInvalid() throws Exception {
        mockMvc.perform(post("/movies")
                        .param("title", "")
                        .param("description", "")
                        .param("director", "")
                        .param("duration", "0"))
                .andExpect(status().isOk())
                .andExpect(view().name("movies/create"))
                .andExpect(model().attributeExists("errors"))
                .andExpect(model().hasErrors());
    }

    @Test
    void createMovie_returnsConflict_whenDuplicateEntry() throws Exception {
        when(service.create(any(CreateMovieDTO.class)))
                .thenThrow(new DataIntegrityViolationException("Duplicate entry"));

        mockMvc.perform(post("/movies")
                        .param("title", "Inception")
                        .param("description", "A mind-bending thriller")
                        .param("director", "Christopher Nolan")
                        .param("duration", "148")
                        .param("releaseDate", "2010-07-16"))
                .andExpect(status().isConflict())
                .andExpect(view().name("movies/bad-request"))
                .andExpect(model().attributeExists("errorMessage"));
    }

    // GET /movies/{id}

    @Test
    void showDetail_returnsDetailView_whenMovieExists() throws Exception {
        when(service.findById(1L)).thenReturn(movieDTO);

        mockMvc.perform(get("/movies/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("movies/detail"))
                .andExpect(model().attributeExists("movie"));
    }

    @Test
    void showDetail_returnsNotFoundView_whenMovieNotFound() throws Exception {
        when(service.findById(99L)).thenThrow(new ResourceNotFoundException("Movie not found with id: 99"));

        mockMvc.perform(get("/movies/99"))
                .andExpect(status().isNotFound())
                .andExpect(view().name("movies/not-found"))
                .andExpect(model().attributeExists("errorMessage"));
    }

    // GET /movies/{id}/edit

    @Test
    void showEditForm_returnsEditView_whenMovieExists() throws Exception {
        when(service.findById(1L)).thenReturn(movieDTO);

        mockMvc.perform(get("/movies/1/edit"))
                .andExpect(status().isOk())
                .andExpect(view().name("movies/edit"))
                .andExpect(model().attributeExists("movie"));
    }

    @Test
    void showEditForm_returnsNotFoundView_whenMovieNotFound() throws Exception {
        when(service.findById(99L)).thenThrow(new ResourceNotFoundException("Movie not found with id: 99"));

        mockMvc.perform(get("/movies/99/edit"))
                .andExpect(status().isNotFound())
                .andExpect(view().name("movies/not-found"))
                .andExpect(model().attributeExists("errorMessage"));
    }

    // POST /movies/{id}/edit

    @Test
    void updateMovie_redirectsToList_whenValid() throws Exception {
        when(service.update(any(UpdateMovieDTO.class))).thenReturn(movieDTO);

        mockMvc.perform(post("/movies/1/edit")
                        .param("id", "1")
                        .param("title", "Inception")
                        .param("description", "A mind-bending thriller")
                        .param("director", "Christopher Nolan")
                        .param("duration", "148")
                        .param("releaseDate", "2010-07-16"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/movies"));
    }

    @Test
    void updateMovie_returnsEditView_whenInvalid() throws Exception {
        mockMvc.perform(post("/movies/1/edit")
                        .param("id", "1")
                        .param("title", "")
                        .param("description", "")
                        .param("director", "")
                        .param("duration", "0"))
                .andExpect(status().isOk())
                .andExpect(view().name("movies/edit"))
                .andExpect(model().attributeExists("errors"))
                .andExpect(model().hasErrors());
    }

    // POST /movies/{id}/delete

    @Test
    void deleteMovie_redirectsToList() throws Exception {
        doNothing().when(service).delete(1L);

        mockMvc.perform(post("/movies/1/delete"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/movies"));

        verify(service).delete(1L);
    }

    @Test
    void deleteMovie_returnsNotFoundView_whenMovieNotFound() throws Exception {
        doThrow(new ResourceNotFoundException("Movie not found with id: 99"))
                .when(service).delete(99L);

        mockMvc.perform(post("/movies/99/delete"))
                .andExpect(status().isNotFound())
                .andExpect(view().name("movies/not-found"));
    }
}
