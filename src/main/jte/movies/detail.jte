@param org.noob.springbootcrudwebapp.dto.MovieDTO movie

<!DOCTYPE html>
<html lang="sv">
<head>
    <meta charset="UTF-8">
    <title>${movie.getTitle()} — FILMBANKEN</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
<div class="app">
    <nav>
        <a href="/movies" class="logo"><span>FILM</span>BANKEN</a>
        <div style="display:flex; gap:0.5rem">
            <a href="/movies" class="btn-search">← Alla filmer</a>
            <a href="/movies/${movie.getId()}/edit" class="btn-primary">Redigera</a>
        </div>
    </nav>

    <div class="page-title">${movie.getTitle()}</div>
    <div class="subtitle">${movie.getDirector()}</div>

    <div class="form-card">
        <div class="detail-grid">
            <div class="detail-group">
                <label>Beskrivning</label>
                <p>${movie.getDescription()}</p>
            </div>
            <div class="detail-group">
                <label>Utgivningsdatum</label>
                <p>${movie.getReleaseDate() != null ? movie.getReleaseDate().toString() : "Okänt"}</p>
            </div>
            <div class="detail-group">
                <label>Speltid</label>
                <p>${movie.getDuration()} min</p>
            </div>
        </div>
    </div>
</div>
</body>
</html>
