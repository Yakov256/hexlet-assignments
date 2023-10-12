package exercise;

import java.util.stream.Collectors;
import java.util.Map;

// BEGIN
class  Tag {
    Map<String, String> attributes;
    String name;

    public Tag(String name, Map<String, String> attributes) {
        this.attributes = attributes;
        this.name = name;
    }

    public String atributsToString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, String> entry: attributes.entrySet()) {
            stringBuilder.append(" " + entry.getKey() + "=\"" + entry.getValue() + "\"");
        }
        return stringBuilder.toString();
    }

}
// END
