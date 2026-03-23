@param String errorMessage

<!DOCTYPE html>
<html lang="sv">
<head>
    <meta charset="UTF-8">
    <title>Hittades inte — FILMBANKEN</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
<div class="app">
    <nav>
        <a href="/" class="logo"><span>FILM</span>BANKEN</a>
        <a href="/movies" class="btn-primary">← Tillbaka</a>
    </nav>

    <div class="error-box">
        <h1>404</h1>
        <p style="color: var(--muted); margin-bottom: 1.5rem">${errorMessage}</p>
        <a href="/movies" class="btn-primary">Gå till filmlistan</a>
    </div>
</div>
</body>
</html>
