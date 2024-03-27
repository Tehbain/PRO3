package opg1;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/*
* Lav en Bil klasse med attributterne registreringsnummer, mærke, model og farve (og
constructor, toString samt get/set metoder)
Lav en App klasse med en main() metode. Opret et HashSet og indsæt nogle Bil objekter i
denne. Lav flere biler med præcis de samme attributter.
*
* Hvad sker der, når man indsætter to bil objekter der har præcis de samme attributter i det
samme HashSet ?
*
* To biler skal opfattes som værende det samme objekt, hvis de har samme
registreringsnummer og mærke. Lav de ændringer der skal til, for at sådanne to biler
opfattes som ens. Det betyder, at der kun skal kunne være en bil med samme
registreringsmummer og mærke i det samme hashSet. Prøv det af ved at indsætte
objekter i HashSet.
*  */
public class App {
    public static void main(String[] args) {
        Set<Bil> cars = new HashSet<>();
        {
            Bil car1 = new Bil("AF2769420", "BMW", "M5", "Black");             //Dupe 1
            Bil car2 = new Bil("MU885764", "Susuki", "Swift", "Red");
            Bil car3 = new Bil("GG96830294", "Dodge", "Challenger", "Beige");
            Bil car4 = new Bil("BV91758299", "Toyota", "Camry", "White");      //Dupe 2
            Bil car5 = new Bil("AF2769420", "BMW", "M5", "Black");             //Dupe 1
            Bil car6 = new Bil("TX76921958", "Toyota", "Prius", "Beige");
            Bil car7 = new Bil("BV91758299", "Toyota", "Camry", "White");      //Dupe 2

            cars.addAll(List.of(car1, car2, car3, car4, car5, car6, car7));
        }

        //Q: Hvad sker der, når man indsætter to bil objekter der har præcis de samme attributter i det samme HashSet?
        //A: Siden vi ikke har overskrevet hashCode() og equals() bliver defaulten brugt fra Object.class
        //   som peger på et sted i memory. Overskriver vi metoderne, kan vi selv sige, om noget er 'ens'
        //   og hvordan et object hashes.

        // Printing
        for (Bil bil : cars) {
            System.out.println(bil);
        }
    }
}

