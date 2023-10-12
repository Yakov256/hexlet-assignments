package exercise;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class PairedTag extends Tag{
    String body;
    List<Tag> children;

    @Override
    public String toString() {
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append("<" + super.name + super.atributsToString() + ">");
        for (Tag tag:children) {
            strBuilder.append(tag.toString());
        }
        strBuilder.append(body + "</" + super.name + ">");

        return strBuilder.toString();
    }

    public PairedTag(String name, Map<String, String> attributes, String body, List<Tag> children) {
        super(name, attributes);
        this.body = body;
        this.children = children;
    }

}
// END
