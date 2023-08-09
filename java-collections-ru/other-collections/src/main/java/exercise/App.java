package exercise;


import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

// BEGIN
class App {
    public static void main(String[] args) {
        // Test sample
        Map<String, Object> data1 = new HashMap<>(
                Map.of("one", "eon", "two", "two", "four", true)
        );
        System.out.println(data1); //=> {two=two, four=true, one=eon}

        Map<String, Object> data2 = new HashMap<>(
                Map.of("two", "own", "zero", 4, "four", true)
        );
        System.out.println(data2); //=> {zero=4, two=own, four=true}

        System.out.println("{four=unchanged, one=deleted, two=changed, zero=added}");
        System.out.println("------------------------------------------------------");

        Map<String, String> result = App.genDiff(data1, data2);
        System.out.println(result);
    }

    public static Set<String> getDiff(Set<String> set1, Set<String> set2) {
        Set<String> interset = new HashSet<>();
        interset.addAll(set1);
        interset.removeAll(set2);
        return interset;
    }

    public static LinkedHashMap genDiff(Map<String, Object> map1, Map<String, Object> map2) {
        LinkedHashMap<String, String> rezultLinkedMap = new LinkedHashMap<>();

        for (Map.Entry<String, Object> entry: map1.entrySet()) {
            String message = "";
            var map2CurrentValue = map2.get(entry.getKey());

            if(map2CurrentValue != null) {
                if(map2CurrentValue.equals(entry.getValue())) {
                    message = "unchanged";
                } else {
                    message = "changed";
                }
            }

            rezultLinkedMap.put(entry.getKey(), message);
        }

        Set<String> set1 = new HashSet<>(map1.keySet());
        Set<String> set2 = new HashSet<>(map2.keySet());

        Set<String> diffSet1 = getDiff(set1, set2);
        for (String str: diffSet1) {
            rezultLinkedMap.put(str, "deleted");
        }

        Set<String> diffSet2 = getDiff(set2, set1);
        for (String str: diffSet2) {
            rezultLinkedMap.put(str, "added");
        }

        return rezultLinkedMap;
    }

}
//END
