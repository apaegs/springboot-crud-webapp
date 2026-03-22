package org.noob.springbootcrudwebapp.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.noob.springbootcrudwebapp.dto.MoviePageDTO;
import org.noob.springbootcrudwebapp.dto.MovieFilterDTO;
import org.noob.springbootcrudwebapp.dto.CreateMovieDTO;
import org.noob.springbootcrudwebapp.dto.MovieDTO;
import org.noob.springbootcrudwebapp.dto.UpdateMovieDTO;
import org.noob.springbootcrudwebapp.entity.Movie;
import org.noob.springbootcrudwebapp.exception.ResourceNotFoundException;
import org.noob.springbootcrudwebapp.mapper.MovieMapper;
import org.noob.springbootcrudwebapp.repository.MovieRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class MovieService {

    private final MovieRepository repository;
    private final MovieMapper mapper;

    public MovieService(MovieRepository repository, MovieMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public MovieDTO create(CreateMovieDTO dto) {
        Objects.requireNonNull(dto);

        Movie movie = mapper.toEntity(dto);
        Movie saved = repository.save(movie);

        return mapper.toDTO(saved);
    }

    public List<MovieDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDTO)
                .toList();
    }

    public MoviePageDTO findPaginated(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Movie> moviePage = repository.findAll(pageable);

        List<MovieDTO> movies = moviePage.getContent()
                .stream()
                .map(mapper::toDTO)
                .toList();

        return new MoviePageDTO(
                movies,
                moviePage.getNumber(),
                moviePage.getTotalPages(),
                moviePage.getTotalElements()
        );
    }

    public MoviePageDTO searchPaginated(MovieFilterDTO filter, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);

        Page<Movie> moviePage = repository.searchPaginated(
                isBlank(filter.getTitle()) ? null : filter.getTitle(),
                isBlank(filter.getDirector()) ? null : filter.getDirector(),
                filter.getFrom(),
                filter.getTo(),
                filter.getMinDuration(),
                filter.getMaxDuration(),
                pageable
        );

        List<MovieDTO> movies = moviePage.getContent()
                .stream()
                .map(mapper::toDTO)
                .toList();

        return new MoviePageDTO(
                movies,
                moviePage.getNumber(),
                moviePage.getTotalPages(),
                moviePage.getTotalElements()
        );
    }

    private boolean isBlank(String value) {
        return value == null || value.isBlank();
    }

    public MovieDTO findById(Long id) {
        Movie movie = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Movie not found with id: " + id));
        return mapper.toDTO(movie);
    }

    @Transactional
    public MovieDTO update(UpdateMovieDTO dto) {
        Objects.requireNonNull(dto);
        Objects.requireNonNull(dto.getId());

        Movie movie = repository.findById(dto.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Movie not found with id: " + dto.getId()));

        mapper.updateEntity(movie, dto);

        return mapper.toDTO(movie);
    }

    @Transactional
    public void delete(Long id) {
        Objects.requireNonNull(id);

        Movie movie = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Movie not found with id: " + id));

        repository.delete(movie);
    }
}
