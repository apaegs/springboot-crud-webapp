@param org.noob.springbootcrudwebapp.dto.CreateMovieDTO movie
@param org.springframework.validation.BindingResult errors

<!DOCTYPE html>
<html lang="sv">
<head>
    <meta charset="UTF-8">
    <title>Ny film — FILMBANKEN</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
<div class="app">
    <nav>
        <a href="/" class="logo"><span>FILM</span>BANKEN</a>
        <a href="/movies" class="btn-primary">← Tillbaka</a>
    </nav>

    <div class="page-title">Ny <span>film</span></div>
    <div class="subtitle">Fyll i informationen nedan</div>

    <div class="form-card">
        <form action="/movies" method="post">
            <div class="form-grid">

                <div class="form-group full">
                    <label>Titel</label>
                    <input type="text" name="title" value="${movie.getTitle() != null ? movie.getTitle() : ""}">
                    @if(errors != null && errors.hasFieldErrors("title"))
                        <span class="error-msg">${errors.getFieldError("title").getDefaultMessage()}</span>
                    @endif
                </div>

                <div class="form-group full">
                    <label>Beskrivning</label>
                    <input type="text" name="description" value="${movie.getDescription() != null ? movie.getDescription() : ""}">
                    @if(errors != null && errors.hasFieldErrors("description"))
                        <span class="error-msg">${errors.getFieldError("description").getDefaultMessage()}</span>
                    @endif
                </div>

                <div class="form-group">
                    <label>Regissör</label>
                    <input type="text" name="director" value="${movie.getDirector() != null ? movie.getDirector() : ""}">
                    @if(errors != null && errors.hasFieldErrors("director"))
                        <span class="error-msg">${errors.getFieldError("director").getDefaultMessage()}</span>
                    @endif
                </div>

                <div class="form-group">
                    <label>Speltid (min)</label>
                    <input type="number" name="duration" value="${movie.getDuration()}">
                    @if(errors != null && errors.hasFieldErrors("duration"))
                        <span class="error-msg">${errors.getFieldError("duration").getDefaultMessage()}</span>
                    @endif
                </div>

                <div class="form-group">
                    <label>Utgivningsdatum</label>
                    <input type="date" name="releaseDate" value="${movie.getReleaseDate() != null ? movie.getReleaseDate().toString() : ""}">
                    @if(errors != null && errors.hasFieldErrors("releaseDate"))
                        <span class="error-msg">${errors.getFieldError("releaseDate").getDefaultMessage()}</span>
                    @endif
                </div>

            </div>
            <button type="submit" class="btn-submit">Spara film</button>
        </form>
    </div>
</div>
</body>
</html>
