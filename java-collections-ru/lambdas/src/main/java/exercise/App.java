package exercise;

import java.util.Arrays;

// BEGIN
class App {

    public static void main(String[] args) {
        String[][] image = {
                {"*", "*", "*", "*"},
                {"*", " ", " ", "*"},
                {"*", " ", " ", "*"},
                {"*", "*", "*", "*"},
                {"*", "*", "*", "*"},
        };

        //System.out.println(Arrays.deepToString(image));
        //System.out.println(Arrays.deepToString(enlargeArrayImage(image)));

    }

    public static String[] doubleString(String[] strFlatArray) {
        String[] doubleFlatStrArray = new String[strFlatArray.length * 2];
        int k = 0;
        for (String str:strFlatArray) {
            doubleFlatStrArray[k++] = str;
            doubleFlatStrArray[k++] = str;
        }

        return doubleFlatStrArray;
    }

    public static String[][] enlargeArrayImage(String[][] strings) {
        if(strings == null) {
            return null;
        }

        String[][] doubleStrArray = new String[strings.length * 2][];

        int k = 0;
        for (String[] strFlatArray: strings) {
            String[] doubleFlatStrArray = doubleString(strFlatArray);
            doubleStrArray[k++] = doubleFlatStrArray;
            doubleStrArray[k++] = doubleFlatStrArray;
        }

        return doubleStrArray;
    }
}
// END
