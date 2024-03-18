@import exercise.dto.users.UsersPage
@param UsersPage page

<html lang="en">
<head>
    <meta charset="utf-8" />
</head>
<body>
<div>
    <main>
        <a href="/users"><H2>Пользователи</H2></a>
        @for(var user : page.getUsers())
            <div>
                <a href="/users/${user.getId()}">${user.getFirstName() + " " + user.getLastName()}</a>
            </div>
        @endfor
    </main>
</div>
</body>
</html>