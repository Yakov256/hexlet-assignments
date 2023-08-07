package exercise;

import java.util.*;
import java.time.LocalDate;
import java.util.stream.Collectors;

// BEGIN
class Sorter {

    public static void main(String[] args) {

        List<Map<String, String>> users = List.of(
                Map.of("name", "Vladimir Nikolaev", "birthday", "1990-12-27", "gender", "male"),
                Map.of("name", "Andrey Petrov", "birthday", "1989-11-23", "gender", "male"),
                Map.of("name", "Anna Sidorova", "birthday", "1996-09-09", "gender", "female"),
                Map.of("name", "John Smith", "birthday", "1989-03-11", "gender", "male"),
                Map.of("name", "Vanessa Vulf", "birthday", "1985-11-16", "gender", "female"),
                Map.of("name", "Alice Lucas", "birthday", "1986-01-01", "gender", "female"),
                Map.of("name", "Elsa Oscar", "birthday", "1970-03-10", "gender", "female")
        );

        System.out.println("-----------------------");
        System.out.println(takeOldestMans(users));

    }

    public static  List<String> sortMylist(List<String> users) {
        List<String> sortedUsers = users.stream()
                .sorted(Comparator.comparing(a -> a))
                .collect(Collectors.toList());
        return sortedUsers;
    }


    public static Map<String, String> reduceMap(Map<String, String> map) {
        Map<String, String> map1 = new HashMap();
        map1.put(map.get("name"), map.get("birthday"));

        return map1;
    }

    public static List<String> takeOldestMans(List<Map<String, String>> users) {

        List<Map<String, String>> sortedUsers = users.stream()
                .filter(element-> element.get("gender").equals("male"))
                .sorted(Comparator.comparing(a -> a.get("birthday")))
                .collect(Collectors.toList());

        System.out.println("1 - " + sortedUsers);


        List<String> sortedUsersList = sortedUsers.stream()
                .map(element-> element.get("name"))
                .collect(Collectors.toList());

        System.out.println("2 - " + sortedUsersList);

/*
        List<String> sortedUsersList1 = new LinkedList<>();

        for(Map<String, String> user: sortedUsers) {
            if(user.get("gender").equals("male")) {
                sortedUsersList1.add(user.get("name"));
            }
        }
        System.out.println("3 - " + sortedUsersList1);
*/
        return sortedUsersList;
    }
}
// END
