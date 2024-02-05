import java.util.ArrayList;
import java.util.List;

public class opg5 {

    /*
    Nedbørsberegning

        Programmer de tre metoder der er specificeret i klassen Nedboer.
        1. Find ugenummeret på den uge man skal starte ferie, hvis man ønsker
        mindst nedbør i de tre uger man holder ferie.
        2. Find ugenummeret på den uge man skal starte ferie, hvis man ønsker
        mindst nedbør og man med en parameter kan angive, hvor mange på
        hinanden følgende uger, man vil holde ferie.
        3. Find ugenummeret på den første uge i den periode hvor nedbøren har
        været præcis den samme flest uger i træk
        
        Hvad er størrelsesordenen af tidskompleksiteten for metoderne?
     */

    public static void main(String[] args) {
        Nedboer nedbør = new Nedboer();
        System.out.println();
        System.out.println("Bedste tre ferieuger starter fra uge " + nedbør.bedsteTreFerieUger());
        System.out.println();

        int antalUger = 4;
        System.out.println("Bedste " + antalUger + " ferieuger starter fra uge: " + nedbør.bedsteFerieUgerStart(antalUger));
        System.out.println();

        System.out.println("Ugen, der indleder flest forekomster af samme nedbør: " + nedbør.ensNedboer());
    }
    
    private static class Nedboer {
        private int[] nedboerPrUge = { 20, 10, 12, 12, 13, 14, 15, 10, 8, 7, 13, 15,
                                       10, 9, 6, 8, 12, 22, 14, 16, 16, 18, 23, 12,
                                       0, 2, 0, 0, 78, 0, 0, 0, 34, 12, 34, 23,
                                       23, 12, 44, 23, 12, 34, 22, 22, 22, 22, 18, 19,
                                       21, 32, 24, 13 };

        /**
         * Returnerer ugenummeret for den uge i året, hvor man skal starte ferien,
         * hvis man ønsker den minimale nedbørsmængde i de tre uger
         *
         * @return
         */

        public int bedsteTreFerieUger() { //O(1)
            int best = nedboerPrUge[0] + nedboerPrUge[1] + nedboerPrUge[2];
            int vacationStart = 0;
            for (int i = 0; i < nedboerPrUge.length - 4; i++) {
                int threeWeeks = nedboerPrUge[i] + nedboerPrUge[i+1] + nedboerPrUge[i+2];
                if (threeWeeks < best) {
                    best = threeWeeks;
                    vacationStart = i+1;
                }
            }
            return vacationStart;
        }

        /**
         * Returnerer ugenummeret for den uge i året, hvor man skal starte ferien,
         * hvis man ønsker den minimale nedbørsmængde i det "antal" uger, der er
         * angivet i paramtereren
         *
         * @return
         */

        public int bedsteFerieUgerStart(int antal) { //O(n^2)

            int[][] weeksPrecip = new int[nedboerPrUge.length - 1 - antal][1];

            for (int i = 0; i < nedboerPrUge.length - 1 - antal; i++) {
                int sum = 0;
                for (int j = 0; j < antal; j++) {
                    sum += nedboerPrUge[i+j];
                }
                weeksPrecip[i][0] = sum;
            }

            int best = Short.MAX_VALUE;
            int vacationStart = 0;
            for (int i = 0; i < nedboerPrUge.length - 1 - antal; i++) {
                if (weeksPrecip[i][0] < best) {
                    best = weeksPrecip[i][0];
                    vacationStart = i+1;
                }
            }
            return vacationStart;
        } 
        

        /**
         * Returnerer ugenummeret på den første uge hvor nedbøren har været præcis
         * den samme flest uger i træk
         *
         * @return
         */
        public int ensNedboer() {
            int repeats = 0;
            int foundWeek = -1;

            for (int i = 0; i < nedboerPrUge.length - 2; i++) {
                repeats = 0;
                if (nedboerPrUge[i] == nedboerPrUge[i+1]) {
                    boolean sameSame = true;
                    int j = i+1;
                    while (sameSame) {
                        if (nedboerPrUge[i] == nedboerPrUge[j]) {
                            repeats++;
                            foundWeek = i+1 - repeats;
                            j++;
                        } else sameSame = false;
                    }
                }
            }
            return foundWeek;
        }
    }
}
