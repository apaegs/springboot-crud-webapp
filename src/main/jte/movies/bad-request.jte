@param String errorMessage

<!DOCTYPE html>
<html lang="sv">
<head>
    <meta charset="UTF-8">
    <title>Bad Request — FILMBANKEN</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
<div class="app">
    <nav>
        <div class="logo"><span>FILM</span>BANKEN</div>
        <a href="/movies" class="btn-primary">← Tillbaka</a>
    </nav>

    <div class="bad-request-box">
        <h1>400</h1>
        <p style="color: var(--muted); margin-bottom: 1.5rem">${errorMessage}</p>
        <a href="/movies" class="btn-primary">Gå till filmlistan</a>
    </div>
</div>
</body>
</html>
