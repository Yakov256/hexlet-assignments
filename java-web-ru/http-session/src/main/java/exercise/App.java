package exercise;

import io.javalin.Javalin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class App {

    private static final List<Map<String, String>> USERS = Data.getUsers();

    static List<Map<String, String>> getPage(int page, int per) {
        List<Map<String, String>> UsersList = Data.getUsers();
        List<Map<String, String>> newList = new ArrayList<>();
        System.out.println(UsersList.size());

        for (int i = (per * page); i < (per * page + per); i++) {
            newList.add(UsersList.get(i));
        }

        return newList;
    }

    public static Javalin getApp() {



        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });

        // BEGIN

        /*app.get("/users", ctx -> {
            var name = ctx.queryParamAsClass("name", String.class).getOrDefault("World");
            ctx.result("Hello, " + name + "!" + "\n" + UsersList);
            //ctx.queryParam("page");
        });*/

        app.get("/users", ctx -> {
            var per = ctx.queryParamAsClass("per", Integer.class).getOrDefault(5);
            var page = ctx.queryParamAsClass("page", Integer.class).getOrDefault(1);

            ctx.result("" + getPage(page,per));

        });
        
        // END

        return app;

    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
