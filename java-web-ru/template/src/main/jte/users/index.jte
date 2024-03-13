@import exercise.dto.users.UsersPage
@param UsersPage page

<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Hello Hexlet!</title>
</head>
<body>
<div class="mx-auto p-4 py-md-5">
    <main>
        <a href="/users">Пользователи</a>

            @for(var course : page.getCourses())
                <div>
                    <h2><a href="/users/${course.getId()}">${course.getFirstName()}</a></h2>
                </div>
            @endfor


    </main>
</div>
</body>
</html>