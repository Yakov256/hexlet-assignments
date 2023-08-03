package exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

// BEGIN
class App {
    public static void main(String[] args) {
        // some tests
        List<String> emailsList = List.of("info@gmail.com",
                "info@yandex.ru",
                "mk@host.com",
                "support@hexlet.io",
                "info@hotmail.com",
                "support.yandex.ru@host.com");

        for (String email : emailsList) {
            System.out.println(email + " - " + isFreeDomain(email));
        }

        System.out.println(getCountOfFreeEmails(emailsList));

    }

    public static long getCountOfFreeEmails(List<String> emailsList) {
        return emailsList.stream()
                .filter(email -> isFreeDomain(email)).
                count();
    }

    public static boolean isFreeDomain(String domain) {
        String[] path = domain.split("@");

        if (path[path.length - 1].equals("gmail.com") ||
                path[path.length - 1].equals("yandex.ru") ||
                path[path.length - 1].equals("hotmail.com")) {
            return true;
        }
        
        return false;
    }

}
// END
