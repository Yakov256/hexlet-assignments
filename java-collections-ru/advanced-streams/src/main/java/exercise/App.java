package exercise;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
//import java.util.stream.Collectors;
//import java.util.Arrays;

// BEGIN
class App {
    public static void main(String[] args) throws IOException {
        // some test
        Path filePath = getFixturePath("s2.conf");
        String file = Files.readString(filePath).trim();
        System.out.println(getForwardedVariables(file));
    }

    private static Path getFixturePath(String fileName) {
        return Paths.get("src", "test", "resources", "fixtures", fileName)
                .toAbsolutePath().normalize();
    }

    public static String getForwardedVariables(String confString) {
        StringBuilder strParam = new StringBuilder();
        int k = 0;

        String[] filteredLinesArray = confString.split("\n");
        for (String line: filteredLinesArray) {
            if(line.contains("environment=\"")) {

                String[] confArray = line.split("\"|,");
                for (String str: confArray) {
                    if(str.contains("X_FORWARDED")) {
                        String[] strParamArray = str.split("X_FORWARDED_");
                        if (k != 0) {
                            strParam.append(",");
                        }
                        k++;
                        strParam.append(strParamArray[1]);
                    }
                }

            }
        }

        return strParam.toString();
    }

}
//END
