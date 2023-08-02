package exercise;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class AppTest {

    @Test
    void testTake() {
        // BEGIN
        // Some change. Nothing changed. Skip committing.
        List<Integer> numbers1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        List<Integer> numbersRez1 = App.take(numbers1, 2);
        Assertions.assertEquals(numbersRez1.size(), 2);
        Assertions.assertEquals(numbersRez1.get(0), 1);
        Assertions.assertEquals(numbersRez1.toString(), "[1, 2]");

        List<Integer> numbers2 = new ArrayList<>(Arrays.asList(7, 3, 10));
        List<Integer> numbersRez2 = App.take(numbers2, 8);
        Assertions.assertEquals(numbersRez2.get(2), 10);
        Assertions.assertEquals(numbersRez2.toString(), "[7, 3, 10]");
        // END
    }
}
