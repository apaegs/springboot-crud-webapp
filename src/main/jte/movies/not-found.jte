@param String errorMessage

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Not Found — MOVIE BANK</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
<div class="app">
    <nav>
        <a href="/" class="logo"><span>MOVIE</span>BANK</a>
        <a href="/movies" class="btn-primary">← Back</a>
    </nav>

    <div class="error-box">
        <h1>404</h1>
        <p style="color: var(--muted); margin-bottom: 1.5rem">${errorMessage}</p>
        <a href="/movies" class="btn-primary">Go to movie list</a>
    </div>
</div>
</body>
</html>
