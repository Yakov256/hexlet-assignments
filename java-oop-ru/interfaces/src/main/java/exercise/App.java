package exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


// BEGIN
public class App {
    public static List<String> buildApartmentsList(List<Home> apartments, int n) {
        List<Home> apartmentsSorted = apartments.stream()
                .sorted((o1, o2) -> o1.compareTo(o2))
                .collect(Collectors.toList());
        List<String> rez = new ArrayList<>();
        int i = 1;
        for (Home apart: apartmentsSorted) {
            rez.add(apart.toString());
            i++;
            if (i > n) {
                break;
            }
        }
        return rez;
    }

}
// END
