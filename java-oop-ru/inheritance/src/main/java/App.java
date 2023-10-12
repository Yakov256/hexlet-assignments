import exercise.PairedTag;
import exercise.SingleTag;

import java.util.List;
import java.util.Map;

public class App {

    public static void main(String[] args) {

        SingleTag img = new SingleTag("img", Map.of("class", "v-10", "id", "wop"));
        //img.toString(); // "<img class="v-10" id="wop">
        System.out.println(img.toString());

        PairedTag div = new PairedTag(
                "div",
                Map.of("class", "y-5"),
                "",
                List.of(
                        new SingleTag("br", Map.of("id", "s")),
                        new SingleTag("hr", Map.of("class", "a-5"))
                )
        );
        // "<div class="y-5"><br id="s"><hr class="a-5"></div>"
        System.out.println(div);




    }

}
