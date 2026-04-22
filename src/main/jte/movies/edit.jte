@param org.noob.springbootcrudwebapp.dto.UpdateMovieDTO movie
@param org.springframework.validation.BindingResult errors

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Edit movie — MOVIE BANK</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
<div class="app">
    <nav>
        <a href="/" class="logo"><span>MOVIE</span>BANK</a>
        <a href="/movies" class="btn-primary">← Back</a>
    </nav>

    <div class="page-title">Edit <span>movie</span></div>
    <div class="subtitle">Update the information below</div>

    <div class="form-card">
        <form action="/movies/${movie.getId()}/edit" method="post">
            <input type="hidden" name="id" value="${movie.getId()}">
            <div class="form-grid">

                <div class="form-group full">
                    <label>Title</label>
                    <input type="text" name="title" value="${movie.getTitle() != null ? movie.getTitle() : ""}">
                    @if(errors != null && errors.hasFieldErrors("title"))
                        <span class="error-msg">${errors.getFieldError("title").getDefaultMessage()}</span>
                    @endif
                </div>

                <div class="form-group full">
                    <label>Description</label>
                    <input type="text" name="description" value="${movie.getDescription() != null ? movie.getDescription() : ""}">
                    @if(errors != null && errors.hasFieldErrors("description"))
                        <span class="error-msg">${errors.getFieldError("description").getDefaultMessage()}</span>
                    @endif
                </div>

                <div class="form-group">
                    <label>Director</label>
                    <input type="text" name="director" value="${movie.getDirector() != null ? movie.getDirector() : ""}">
                    @if(errors != null && errors.hasFieldErrors("director"))
                        <span class="error-msg">${errors.getFieldError("director").getDefaultMessage()}</span>
                    @endif
                </div>

                <div class="form-group">
                    <label>Runtime (min)</label>
                    <input type="number" name="duration" value="${movie.getDuration()}">
                    @if(errors != null && errors.hasFieldErrors("duration"))
                        <span class="error-msg">${errors.getFieldError("duration").getDefaultMessage()}</span>
                    @endif
                </div>

                <div class="form-group">
                    <label>Release date</label>
                    <input type="date" name="releaseDate" value="${movie.getReleaseDate() != null ? movie.getReleaseDate().toString() : ""}">
                    @if(errors != null && errors.hasFieldErrors("releaseDate"))
                        <span class="error-msg">${errors.getFieldError("releaseDate").getDefaultMessage()}</span>
                    @endif
                </div>

            </div>
            <button type="submit" class="btn-submit"
                    onclick="return confirm('Are you sure you want to save the changes?')">
                Save changes
            </button>
        </form>
        <form action="/movies/${movie.getId()}/delete" method="post"
              style="margin-top: 1rem"
              onsubmit="return confirm('Are you sure you want to delete ${movie.getTitle()}?')">
            <button type="submit" class="btn-delete" style="width:100%">Delete movie</button>
        </form>
    </div>
</div>
</body>
</html>
