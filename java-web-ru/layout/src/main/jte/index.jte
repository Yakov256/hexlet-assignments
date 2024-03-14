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
            <h1>Добрый день!</h1>
            <a href="/users">Пользователи</a>
            <a href="/">Эта страница</a>

        </header>

        <main>

        </main>

        @if (footer != null)
            <div class="footer">
                ${footer}
            </div>
        @endif

    </body>
</html>