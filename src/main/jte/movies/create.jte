@param org.noob.springbootcrudwebapp.dto.CreateMovieDTO movie
@param org.springframework.validation.BindingResult errors

<!DOCTYPE html>
<html>
<head>
    <title>Create Movie</title>
</head>
<body>

<h1>Create Movie</h1>

<form action="/movies" method="post">

    <div>
        <label>Title:</label>
        <input type="text" name="title" value="${movie.getTitle()}">
        @if (errors != null && errors.hasFieldErrors("title"))
            <p>${errors.getFieldError("title").getDefaultMessage()}</p>
        @endif
    </div>

    <div>
        <label>Description:</label>
        <input type="text" name="description" value="${movie.getDescription()}">
        @if (errors != null && errors.hasFieldErrors("description"))
            <p>${errors.getFieldError("description").getDefaultMessage()}</p>
        @endif
    </div>

    <div>
        <label>Release Date:</label>
        <input type="date" name="releaseDate" value="${movie.getReleaseDate() != null ? movie.getReleaseDate().toString() : ""}">
        @if (errors != null && errors.hasFieldErrors("releaseDate"))
            <p>${errors.getFieldError("releaseDate").getDefaultMessage()}</p>
        @endif
    </div>

    <div>
        <label>Director:</label>
        <input type="text" name="director" value="${movie.getDirector()}">
        @if (errors != null && errors.hasFieldErrors("director"))
            <p>${errors.getFieldError("director").getDefaultMessage()}</p>
        @endif
    </div>

    <div>
        <label>Duration:</label>
        <input type="number" name="duration" value="${movie.getDuration()}">
        @if (errors != null && errors.hasFieldErrors("duration"))
            <p>${errors.getFieldError("duration").getDefaultMessage()}</p>
        @endif
    </div>

    <button type="submit">Save</button>

</form>

<a href="/movies">Back</a>

</body>
</html>
