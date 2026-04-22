@import org.noob.springbootcrudwebapp.dto.MovieDTO
@param org.noob.springbootcrudwebapp.dto.MoviePageDTO moviePage

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Movies — MOVIE BANK</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
<div class="app">
    <nav>
        <a href="/" class="logo"><span>MOVIE</span>BANK</a>
        <div style="display:flex; gap:0.5rem">
            <a href="/movies/search" class="btn-search">Search movies</a>
            <a href="/movies/new" class="btn-primary">+ New movie</a>
        </div>
    </nav>

    <div class="page-title">All <span>movies</span></div>
    <div class="subtitle">${moviePage.getTotalElements()} movies in database</div>

    <div class="movie-grid">
        @for(MovieDTO movie : moviePage.getMovies())
            <a href="/movies/${movie.getId()}" class="movie-card">
                <div class="card-banner" style="background: linear-gradient(90deg, #FF4D6D, #7B2FBE)"></div>
                <div class="card-body">
                    <div class="card-title">${movie.getTitle()}</div>
                    <div class="card-meta">${movie.getDirector()}</div>
                    <div class="card-description">${movie.getDescription()}</div>
                    <div style="display:flex; gap:0.4rem">
            <span class="badge badge-year">
                ${movie.getReleaseDate() != null ? String.valueOf(movie.getReleaseDate().getYear()) : ""}
            </span>
                        <span class="badge badge-duration">${movie.getDuration()} min</span>
                    </div>
                </div>
            </a>
        @endfor
    </div>

    <div class="pagination">
        @if(moviePage.isHasPrevious())
            <a href="/movies?page=${moviePage.getCurrentPage() - 1}" class="page-btn">← Previous</a>
        @endif
        <span class="page-info">
            ${moviePage.getTotalPages() > 0
                ? "Page " + (moviePage.getCurrentPage() + 1) + " of " + moviePage.getTotalPages()
                : "No pages to display"}
        </span>
        @if(moviePage.isHasNext())
            <a href="/movies?page=${moviePage.getCurrentPage() + 1}" class="page-btn">Next →</a>
        @endif
    </div>

</div>
</body>
</html>
