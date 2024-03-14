@import exercise.dto.users.UsersPage
@import gg.jte.Content

@param UsersPage page
@param Content content
@param Content footer = null

<html lang="en">
<head>
    <meta charset="utf-8" />
</head>

<body>

<header>
    <h1>header</h1>
    <a href="/">Главная</a>
    <a href="/users">Пользователи</a>
</header>

<main>
    <a href="/users">Пользователи</a>

    <div class="content">
        ${content}
    </div>
</main>

@if (footer != null)
    <div class="footer">
        ${footer}
    </div>
@endif

</body>
</html>