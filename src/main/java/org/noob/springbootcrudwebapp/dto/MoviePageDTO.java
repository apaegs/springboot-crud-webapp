package org.noob.springbootcrudwebapp.dto;

import java.util.List;

public class MoviePageDTO {

    private List<MovieDTO> movies;
    private int currentPage;
    private int totalPages;
    private long totalElements;
    private boolean hasNext;
    private boolean hasPrevious;

    public MoviePageDTO(List<MovieDTO> movies, int currentPage,
                        int totalPages, long totalElements) {
        this.movies = movies;
        this.currentPage = currentPage;
        this.totalPages = totalPages;
        this.totalElements = totalElements;
        this.hasNext = currentPage < totalPages - 1;
        this.hasPrevious = currentPage > 0;
    }

    public List<MovieDTO> getMovies() { return movies; }
    public int getCurrentPage() { return currentPage; }
    public int getTotalPages() { return totalPages; }
    public long getTotalElements() { return totalElements; }
    public boolean isHasNext() { return hasNext; }
    public boolean isHasPrevious() { return hasPrevious; }
}
