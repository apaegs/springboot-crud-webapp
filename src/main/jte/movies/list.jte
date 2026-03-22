@import org.noob.springbootcrudwebapp.dto.MovieDTO
@param java.util.List<MovieDTO> movies

<!DOCTYPE html>
<html lang="sv">
<head>
    <meta charset="UTF-8">
    <title>Filmer — FILMBANKEN</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
<div class="app">
    <nav>
        <div class="logo"><span>FILM</span>BANKEN</div>
        <div style="display:flex; gap:0.5rem">
            <a href="/movies/search" class="btn-search">Sök filmer</a>
            <a href="/movies/new" class="btn-primary">+ Ny film</a>
        </div>
    </nav>

    <div class="page-title">Alla <span>filmer</span></div>
    <div class="subtitle">${movies.size()} filmer i databasen</div>

    <div class="movie-grid">
        @for(MovieDTO movie : movies)
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
</div>
</body>
</html>
