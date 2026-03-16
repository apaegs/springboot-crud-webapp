package org.noob.springbootcrudwebapp.repository;

import org.noob.springbootcrudwebapp.entity.Movie;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends ListCrudRepository<Movie, Long> {
}
