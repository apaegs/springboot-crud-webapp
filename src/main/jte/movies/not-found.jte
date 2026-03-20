@param String errorMessage

<!DOCTYPE html>
<html lang="sv">
<head>
    <meta charset="UTF-8">
    <title>Hittades inte — CineVault</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
<div class="app">
    <nav>
        <div class="logo"><span>Cine</span>Vault</div>
        <a href="/movies" class="btn-primary">← Tillbaka</a>
    </nav>

    <div class="not-found-box">
        <h1>404</h1>
        <p style="color: var(--muted); margin-bottom: 1.5rem">${errorMessage}</p>
        <a href="/movies" class="btn-primary">Gå till filmlistan</a>
    </div>
</div>
</body>
</html>
