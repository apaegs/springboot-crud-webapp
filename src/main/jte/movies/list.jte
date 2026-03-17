@import org.noob.springbootcrudwebapp.dto.MovieDTO
@import java.time.format.DateTimeFormatter
@param java.util.List<org.noob.springbootcrudwebapp.dto.MovieDTO> movies

<h1>Movies</h1>
<a href="/movies/new">Add Movie</a>

<table border="1">
    <tr>
        <th>Title</th>
        <th>Director</th>
        <th>Release Date</th>
        <th>Duration</th>
        <th>Actions</th>
    </tr>

    @for(MovieDTO movie : movies)
        <tr>
            <td>${movie.getTitle()}</td>
            <td>${movie.getDirector()}</td>
            <td>
                ${movie.getReleaseDate() != null ? movie.getReleaseDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) : ""}
            </td>
            <td>${movie.getDuration()}</td>
            <td>
                <form action="/movies/${movie.getId()}/edit" method="get" style="display:inline">
                    <button type="submit">Edit</button>
                </form>
                <form action="/movies/${movie.getId()}/delete" method="post" style="display:inline">
                    <button type="submit">Delete</button>
                </form>
            </td>
        </tr>
    @endfor
</table>
