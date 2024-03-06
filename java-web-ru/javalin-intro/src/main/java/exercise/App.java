package exercise;

// BEGIN

// END

public final class App {

    public static Javalin getApp() {

        // BEGIN
        // Создаем приложение
        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });
        // Описываем, что загрузится по адресу /
        app.get("/", ctx -> ctx.result("Hello World"));
        //app.start(7070); // Стартуем веб-сервер
        return  app;
        // END
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
