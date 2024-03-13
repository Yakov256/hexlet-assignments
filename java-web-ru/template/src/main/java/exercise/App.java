package exercise;

import io.javalin.Javalin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import io.javalin.http.NotFoundResponse;
import exercise.model.User;
import exercise.dto.users.UserPage;
import exercise.dto.users.UsersPage;
import java.util.Collections;

public final class App {

    // Каждый пользователь представлен объектом класса User
    private static final List<User> USERS = Data.getUsers();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });

        // BEGIN

        /*app.get("/users", ctx -> {
            var courses = USERS;
            //var page = new UsersPage(USERS);
            List<String> lst = new ArrayList<>();
            lst.add("123");
            lst.add("asd");
            HashMap<String, String > hm = new HashMap<>();
            hm.put("1", "qwe");
            hm.put("2", "asd");
            ctx.render("users/index.jte", hm);
        });*/

        app.get("/users", ctx -> {
            var page = new UsersPage(USERS);
            ctx.render("users/index.jte", Collections.singletonMap("page", page));
        });


        app.get("/users/{id}", ctx -> {
            var id = ctx.pathParam("id");
            Long idL = Long.parseLong(id);
            var user = USERS.stream().filter(u -> u.getId() == idL).findFirst().orElse(null);
            if(user == null) {
                throw new NotFoundResponse("User not found");
            }
            var userPage = new UserPage(user);
            ctx.render("users/show.jte", Collections.singletonMap("page", userPage));
        });

        /*app.get("/users", ctx -> {
            ctx.render("users/index.jte");
        });*/

        /*app.get("/", ctx -> {
            ctx.render("index.jte");
        });*/

        // END

        app.get("/", ctx -> {
            ctx.render("index.jte");
        });

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
