package exercise;

// BEGIN
public class LabelTag implements TagInterface {
    TagInterface inputTag;
    String label;

    public LabelTag(String labelTag, TagInterface inputTag) {
        this.inputTag = inputTag;
        this.label = labelTag;
    }

    @Override
    public String render() {
        return "<label>" + label + inputTag.render() + "</label>";
    }
}
// END
