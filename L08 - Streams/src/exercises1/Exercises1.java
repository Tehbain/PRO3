package exercises1;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Exercises1 {

    public static void main(String[] args) {
        String tab = "\t\t";

        // Liste med tal mellem 1 - 50
        List<Integer> list = List.of(1,2,3,2,1,6,3,4,5,2,3,8,8,9,34,32);
        list.stream().forEach(e-> System.out.println(e+1));
        System.out.println();

        System.out.println("Største element i listen");
        System.out.println(tab + list.stream().max((int1, int2) -> int1 - int2).get());
        //	Udskriver det største element i listen

        System.out.println("Er alle tal i listen mindre end 50?");
        System.out.println(tab + list.stream().noneMatch(thisInt -> thisInt > 50));
        //	Afgør og udskriver om alle tallene i listen er mindre end 50

        System.out.println("Forekomsten af lige tal:");
        System.out.println(tab + list.stream().filter(thisInt -> thisInt % 2 == 0).count());
        // 	Udskriver antallet af lige tal i listen

        System.out.println("Forekomsten af ulige tal:");
        System.out.println(tab + list.stream().filter(thisInt -> thisInt % 2 == 1).count());
        //	Udskriver antallet af ulige tal i listen

        System.out.println("Statistik af listen:");
        IntSummaryStatistics stats = list.stream()
                .mapToInt(thisInt -> (int)thisInt)
                .summaryStatistics();
        System.out.println(tab + "antallet af tal");
        System.out.println(tab + stats.getCount());
        System.out.println(tab + "antallet af elementer større end gennemsnit");
        System.out.println(tab + list.stream().filter(thisInt -> thisInt > stats.getAverage()).count());
        System.out.println(tab + "antallet af elementer mindre end gennemsnit");
        System.out.println(tab + list.stream().filter(thisInt -> thisInt < stats.getAverage()).count());
        //  Udskriver
        //      Gennemsnittet af tallene i listen
        //      Antallet af tallene i listen
        //      Antallet af tallene i listen der er større end gennemsnittet
        //      Antallet af tallene i listen der er mindre end gennemsnittet

        System.out.println("Antal forekomster af distinkte tal");
        System.out.println(tab + list.stream().distinct().count());
        //	Udskriver antallet af gange de forskellige tal forekommer i listen

        System.out.println("Antal forekomst af distinkte tal i rækkefølge");
        list.stream()
                .collect(Collectors.groupingBy(e -> e, TreeMap::new, Collectors.counting()))
                .forEach((k,v) -> System.out.print(k + ":" + v + ", "));
        //	Udskriver antallet af gange de forskellige tal forekommer i listen i sorteret orden
    }
}
