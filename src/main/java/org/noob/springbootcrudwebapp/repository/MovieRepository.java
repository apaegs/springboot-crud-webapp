package org.noob.springbootcrudwebapp.repository;

import org.noob.springbootcrudwebapp.entity.Movie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MovieRepository extends ListCrudRepository<Movie, Long> {

    @Query("""
            SELECT m FROM Movie m WHERE
            (:title IS NULL OR LOWER(m.title) LIKE LOWER(CONCAT('%', :title, '%')))
            AND (:director IS NULL OR LOWER(m.director) LIKE LOWER(CONCAT('%', :director, '%')))
            AND (:from IS NULL OR m.releaseDate >= :from)
            AND (:to IS NULL OR m.releaseDate <= :to)
            AND (:minDuration IS NULL OR m.duration >= :minDuration)
            AND (:maxDuration IS NULL OR m.duration <= :maxDuration)
            """)
    List<Movie> search(
            @Param("title") String title,
            @Param("director") String director,
            @Param("from") LocalDate from,
            @Param("to") LocalDate to,
            @Param("minDuration") Integer minDuration,
            @Param("maxDuration") Integer maxDuration
    );
}
