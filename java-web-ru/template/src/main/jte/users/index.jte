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
                    @for(var course : page.getCourses())
                        <div>
                            <a href="/users/${course.getId()}">${course.getFirstName() + " " + course.getLastName()}</a>
                        </div>
                    @endfor
            </main>
        </div>
    </body>
</html>