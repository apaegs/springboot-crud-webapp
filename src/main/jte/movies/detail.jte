@param org.noob.springbootcrudwebapp.dto.MovieDTO movie

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${movie.getTitle()} — MOVIE BANK</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
<div class="app">
    <nav>
        <a href="/movies" class="logo"><span>MOVIE</span>BANK</a>
        <div style="display:flex; gap:0.5rem">
            <a href="/movies" class="btn-search">← All movies</a>
            <a href="/movies/${movie.getId()}/edit" class="btn-primary">Edit</a>
        </div>
    </nav>

    <div class="page-title">${movie.getTitle()}</div>
    <div class="subtitle">${movie.getDirector()}</div>

    <div class="form-card">
        <div class="detail-grid">
            <div class="detail-group">
                <label>Description</label>
                <p>${movie.getDescription()}</p>
            </div>
            <div class="detail-group">
                <label>Release date</label>
                <p>${movie.getReleaseDate() != null ? movie.getReleaseDate().toString() : "Unknown"}</p>
            </div>
            <div class="detail-group">
                <label>Runtime</label>
                <p>${movie.getDuration()} min</p>
            </div>
        </div>
    </div>
</div>
</body>
</html>
