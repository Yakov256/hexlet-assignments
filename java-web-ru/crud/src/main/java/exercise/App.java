package exercise;

import io.javalin.Javalin;
import exercise.controller.PostsController;
import exercise.controller.RootController;
import exercise.util.NamedRoutes;
import io.javalin.rendering.template.JavalinJte;

public final class App {

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        app.get(NamedRoutes.rootPath(), RootController::index);

        // BEGIN
        app.get(  "/posts",           PostsController::index);
        app.get(  "/posts/{id}",      PostsController::show);
        app.get(  "/posts/build",     PostsController::build);
        app.post( "/posts",           PostsController::create);
        app.get(  "/posts/{id}/edit", PostsController::edit);
        app.patch("/posts/{id}",      PostsController::update);
        // END

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
