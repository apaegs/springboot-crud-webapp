@import org.noob.springbootcrudwebapp.dto.MovieDTO
@param org.noob.springbootcrudwebapp.dto.MoviePageDTO moviePage
@param org.noob.springbootcrudwebapp.dto.MovieFilterDTO filter

<!DOCTYPE html>
<html lang="sv">
<head>
    <meta charset="UTF-8">
    <title>Sök filmer — FILMBANKEN</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
<div class="app">
    <nav>
        <div class="logo"><span>FILM</span>BANKEN</div>
        <div style="display:flex; gap:0.5rem">
            <a href="/movies" class="btn-search">← Alla filmer</a>
            <a href="/movies/new" class="btn-primary">+ Ny film</a>
        </div>
    </nav>

    <div class="page-title">Sök <span>filmer</span></div>
    <div class="subtitle">${moviePage.getTotalElements()} träffar</div>

    <form action="/movies/search" method="get" class="filter-form">
        <div class="filter-grid">
            <div class="form-group">
                <label>Titel</label>
                <input type="text" name="title"
                       value="${filter.getTitle() != null ? filter.getTitle() : ""}">
            </div>
            <div class="form-group">
                <label>Regissör</label>
                <input type="text" name="director"
                       value="${filter.getDirector() != null ? filter.getDirector() : ""}">
            </div>
            <div class="form-group">
                <label>Från datum</label>
                <input type="date" name="from"
                       value="${filter.getFrom() != null ? filter.getFrom().toString() : ""}">
            </div>
            <div class="form-group">
                <label>Till datum</label>
                <input type="date" name="to"
                       value="${filter.getTo() != null ? filter.getTo().toString() : ""}">
            </div>
            <div class="form-group">
                <label>Min speltid</label>
                <input type="number" name="minDuration"
                       value="${filter.getMinDuration() != null ? String.valueOf(filter.getMinDuration()) : ""}">
            </div>
            <div class="form-group">
                <label>Max speltid</label>
                <input type="number" name="maxDuration"
                       value="${filter.getMaxDuration() != null ? String.valueOf(filter.getMaxDuration()) : ""}">
            </div>
        </div>
        <div class="filter-actions">
            <button type="submit" class="btn-primary">Sök</button>
            <a href="/movies/search" class="btn-clear">Rensa filter</a>
        </div>
    </form>

    <div class="movie-grid">
        @for(MovieDTO movie : moviePage.getMovies())
            <div class="movie-card">
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
                    <div class="card-actions">
                        <a href="/movies/${movie.getId()}/edit" class="btn-edit">Redigera</a>
                        <form action="/movies/${movie.getId()}/delete" method="post" style="flex:1">
                            <button type="submit" class="btn-delete" style="width:100%">Ta bort</button>
                        </form>
                    </div>
                </div>
            </div>
        @endfor
    </div>

    <div class="pagination">
        @if(moviePage.isHasPrevious())
            <a href="/movies/search?page=${moviePage.getCurrentPage() - 1}&title=${filter.getTitle() != null ? filter.getTitle() : ""}&director=${filter.getDirector() != null ? filter.getDirector() : ""}" class="page-btn">← Föregående</a>
        @endif
        <span class="page-info">
            Sida ${moviePage.getCurrentPage() + 1} av ${moviePage.getTotalPages()}
        </span>
        @if(moviePage.isHasNext())
            <a href="/movies/search?page=${moviePage.getCurrentPage() + 1}&title=${filter.getTitle() != null ? filter.getTitle() : ""}&director=${filter.getDirector() != null ? filter.getDirector() : ""}" class="page-btn">Nästa →</a>
        @endif
    </div>

</div>
</body>
</html>
