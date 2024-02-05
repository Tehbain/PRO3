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

    
    
    private class Nedboer {
        private int[] nedboerPrUge = { 20, 10, 12, 12, 13, 14, 15, 10, 8, 7, 13,
                                        15, 10, 9, 6, 8, 12, 22, 14, 16, 16, 18, 23, 12, 0, 2, 0, 0, 78, 0,
                                        0, 0, 34, 12, 34, 23, 23, 12, 44, 23, 12, 34, 22, 22, 22, 22, 18,
                                        19, 21, 32, 24, 13 };

        /**
         * Returnerer ugenummeret for den uge i året, hvor man skal starte ferien,
         * hvis man ønsker den minimale nedbørsmængde i de tre uger
         *
         * @return
         */

        public int bedsteTreFerieUger() {
            
            int best = 0;

            for (int i = 0; i < nedboerPrUge.length - 4; i++) {
                
            }
            
            return -1;
        }

        /**
         * Returnerer ugenummeret for den uge i året, hvor man skal starte ferien,
         * hvis man ønsker den minimale nedbørsmængde i det "antal" uger, der er
         * angivet i paramtereren
         *
         * @return
         */

        public int bedsteFerieUgerStart(int antal) {
            // TODO return -1 kun indsat så der ikke er compile fejl
            return -1;
        }

        /**
         * Returnerer ugenummeret på den første uge hvor nedbøren har været præcis
         * den samme flest uger i træk
         *
         * @return
         */
        public int ensNedboer() {
            // TODO return -1 kun indsat så der ikke er compile fejl
            return -1;
        }
    }
}
