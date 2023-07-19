package exercise;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// BEGIN
class App {

    public static boolean scrabble(String lettersCollections, String word) {
        boolean isScrabble = true;
        List<Character> lettersChar = new LinkedList<Character>();
        char[] charArray = lettersCollections.toLowerCase().toCharArray();
        for (char oneChar:charArray) {
            lettersChar.add(oneChar);
        }

        char[] mainWordArray = word.toLowerCase().toCharArray();

        for (char oneChar:mainWordArray) {
            int index = lettersChar.indexOf(oneChar);
            if (index == -1) {
                isScrabble = false;
                break;
            } else {
                lettersChar.remove(index);
            }
        }

        return isScrabble;
    }
}
//END
