@import exercise.dto.users.UserPage
@param UserPage page

<html lang="en">
    <head>
        <meta charset="utf-8" />
    </head>
    <body>
    <div class="mx-auto p-4 py-md-5">
        <main>
            <a href="/users">Пользователи</a>
        </main>
        <main>
            <p>${page.getUser().getFirstName() + " " + page.getUser().getLastName()}</p>
            <p>${page.getUser().getId()}</p>
            <p>${page.getUser().getEmail()}</p>
        </main>
    </div>
    </body>
</html>
