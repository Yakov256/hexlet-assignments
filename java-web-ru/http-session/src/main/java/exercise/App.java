package exercise;

import io.javalin.Javalin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class App {

    private static final List<Map<String, String>> USERS = Data.getUsers();

    static List<Map<String, String>> getPage(int page, int per) {
        List<Map<String, String>> newList = new ArrayList<>();
        System.out.println(USERS.size());

        for (int i = (per * (page - 1)); i < (per * (page - 1) + per); i++) {
            newList.add(USERS.get(i));
        }

        return newList;
    }

    public static Javalin getApp() {



        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });

        // BEGIN
        app.get("/users", ctx -> {
            var per = ctx.queryParamAsClass("per", Integer.class).getOrDefault(5);
            var page = ctx.queryParamAsClass("page", Integer.class).getOrDefault(1);
            ctx.json(getPage(page, per));
        });
        // END

        return app;

    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
