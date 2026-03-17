package org.noob.springbootcrudwebapp.service;

import org.noob.springbootcrudwebapp.dto.CreateMovieDTO;
import org.noob.springbootcrudwebapp.dto.MovieDTO;
import org.noob.springbootcrudwebapp.dto.UpdateMovieDTO;
import org.noob.springbootcrudwebapp.entity.Movie;
import org.noob.springbootcrudwebapp.mapper.MovieMapper;
import org.noob.springbootcrudwebapp.repository.MovieRepository;
import org.springframework.stereotype.Service;

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

    // CREATE
    public MovieDTO create(CreateMovieDTO dto) {
        Objects.requireNonNull(dto, "CreateMovieDTO must not be null");

        Movie movie = mapper.toEntity(dto);
        Movie saved = repository.save(movie);

        return mapper.toDTO(saved);
    }

    // READ ALL
    public List<MovieDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDTO)
                .toList();
    }

    // UPDATE
    public MovieDTO update(UpdateMovieDTO dto) {
        Objects.requireNonNull(dto, "UpdateMovieDTO must not be null");

        Movie movie = repository.findById(dto.getId())
                .orElseThrow(() -> new IllegalArgumentException("Movie not found with id: " + dto.getId()));

        mapper.updateEntity(movie, dto);
        Movie updated = repository.save(movie);

        return mapper.toDTO(updated);
    }

    // DELETE
    public void delete(Long id) {
        Objects.requireNonNull(id, "Movie id must not be null");

        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Movie not found with id: " + id);
        }

        repository.deleteById(id);
    }
}
