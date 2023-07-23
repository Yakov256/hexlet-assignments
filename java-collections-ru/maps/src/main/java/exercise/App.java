package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
//import java.util.Arrays;

public class App {

    //public static void main(String[] args) {
     //  System.out.println(toString(getWordCount("the java is the best programming language java")));
    //}

    public static Map getWordCount(String str) {

        Map<String, Integer> people = new HashMap<>();
        String[] strArray = str.split(" ");

        for (String currentStr: strArray) {
            if (people.containsKey(currentStr)) {
                people.put(currentStr, people.get(currentStr) + 1);
            } else {
                people.put(currentStr, 1);
            }
        }

        return people;
    }

    public static String toString(Map map) {
        StringBuilder stringBuilder = new StringBuilder();
        var keySet = map.keySet();

        stringBuilder.append("// {\n");
        for (var key: keySet) {
            stringBuilder.append("//   " + key + ": " +  map.get(key) + "\n");
        }
        stringBuilder.append("// }\n");

        return stringBuilder.toString();
    }

}
//END
