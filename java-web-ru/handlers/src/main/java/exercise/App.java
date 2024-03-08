package exercise;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.Javalin;

public final class App {

    public static Javalin getApp() {

        // BEGIN
        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });

        ObjectMapper objectMapper = new ObjectMapper();
        //Обработчик GET /phones. Он должен возвращать список телефонов, закодированный в json
        app.get("/phones", ctx -> ctx.result(objectMapper.writeValueAsString(Data.getPhones())));

        //Обработчик GET /domains. Он должен возвращать список доменов, закодированный в json
        app.get("/domains", ctx -> ctx.result(objectMapper.writeValueAsString(Data.getDomains())));

        return  app;
        // END
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
