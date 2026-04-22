@import org.noob.springbootcrudwebapp.dto.MovieDTO
@import java.net.URLEncoder
@import java.nio.charset.StandardCharsets
@param org.noob.springbootcrudwebapp.dto.MoviePageDTO moviePage
@param org.noob.springbootcrudwebapp.dto.MovieFilterDTO filter

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Search movies — MOVIE BANK</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
<div class="app">
    <nav>
        <a href="/" class="logo"><span>MOVIE</span>BANK</a>
        <div style="display:flex; gap:0.5rem">
            <a href="/movies" class="btn-search">← All movies</a>
            <a href="/movies/new" class="btn-primary">+ New movie</a>
        </div>
    </nav>

    <div class="page-title">Search <span>movies</span></div>
    <div class="subtitle">${moviePage.getTotalElements()} results</div>

    <form action="/movies/search" method="get" class="filter-form">
        <div class="filter-grid">
            <div class="form-group">
                <label>Title</label>
                <input type="text" name="title"
                       value="${filter.getTitle() != null ? filter.getTitle() : ""}">
            </div>
            <div class="form-group">
                <label>Director</label>
                <input type="text" name="director"
                       value="${filter.getDirector() != null ? filter.getDirector() : ""}">
            </div>
            <div class="form-group">
                <label>From date</label>
                <input type="date" name="from"
                       value="${filter.getFrom() != null ? filter.getFrom().toString() : ""}">
            </div>
            <div class="form-group">
                <label>To date</label>
                <input type="date" name="to"
                       value="${filter.getTo() != null ? filter.getTo().toString() : ""}">
            </div>
            <div class="form-group">
                <label>Min duration</label>
                <input type="number" name="minDuration"
                       value="${filter.getMinDuration() != null ? String.valueOf(filter.getMinDuration()) : ""}">
            </div>
            <div class="form-group">
                <label>Max duration</label>
                <input type="number" name="maxDuration"
                       value="${filter.getMaxDuration() != null ? String.valueOf(filter.getMaxDuration()) : ""}">
            </div>
        </div>
        <div class="filter-actions">
            <button type="submit" class="btn-primary">Search</button>
            <a href="/movies/search" class="btn-clear">Clear filter</a>
        </div>
    </form>

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
            <a href="/movies/search?page=${moviePage.getCurrentPage() - 1}&title=${URLEncoder.encode(filter.getTitle() != null ? filter.getTitle() : "", StandardCharsets.UTF_8)}&director=${URLEncoder.encode(filter.getDirector() != null ? filter.getDirector() : "", StandardCharsets.UTF_8)}&from=${URLEncoder.encode(filter.getFrom() != null ? filter.getFrom().toString() : "", StandardCharsets.UTF_8)}&to=${URLEncoder.encode(filter.getTo() != null ? filter.getTo().toString() : "", StandardCharsets.UTF_8)}&minDuration=${URLEncoder.encode(filter.getMinDuration() != null ? String.valueOf(filter.getMinDuration()) : "", StandardCharsets.UTF_8)}&maxDuration=${URLEncoder.encode(filter.getMaxDuration() != null ? String.valueOf(filter.getMaxDuration()) : "", StandardCharsets.UTF_8)}" class="page-btn">← Previous</a>
        @endif
        <span class="page-info">
            ${moviePage.getTotalPages() > 0
                ? "Page " + (moviePage.getCurrentPage() + 1) + " of " + moviePage.getTotalPages()
                : "No pages to display"}
        </span>
        @if(moviePage.isHasNext())
            <a href="/movies/search?page=${moviePage.getCurrentPage() + 1}&title=${URLEncoder.encode(filter.getTitle() != null ? filter.getTitle() : "", StandardCharsets.UTF_8)}&director=${URLEncoder.encode(filter.getDirector() != null ? filter.getDirector() : "", StandardCharsets.UTF_8)}&from=${URLEncoder.encode(filter.getFrom() != null ? filter.getFrom().toString() : "", StandardCharsets.UTF_8)}&to=${URLEncoder.encode(filter.getTo() != null ? filter.getTo().toString() : "", StandardCharsets.UTF_8)}&minDuration=${URLEncoder.encode(filter.getMinDuration() != null ? String.valueOf(filter.getMinDuration()) : "", StandardCharsets.UTF_8)}&maxDuration=${URLEncoder.encode(filter.getMaxDuration() != null ? String.valueOf(filter.getMaxDuration()) : "", StandardCharsets.UTF_8)}" class="page-btn">Next →</a>
        @endif
    </div>

</div>
</body>
</html>
