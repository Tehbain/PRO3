import java.util.Arrays;

public class opg6 {

    public static void main(String[] args) {
        char[] legeplads = congo();

        System.out.println(Arrays.toString(legeplads));
        System.out.println();

        kongLeopold(legeplads);
        System.out.println(Arrays.toString(legeplads));

    }

    /**
     * Programmer metoden så den får den mindst mulige tidskompleksitet.
     * Dvs. arrayet må kun gennemløbes én gang og der må ikke bruges et ekstra
     * hjælpe array.
     */
    private static void kongLeopold(char[] charArr) {
        int n = charArr.length;
        int biggus = codeChar('R');
        for (int i = 0; i < n - 1; i++) {
            charArr[i] = codeChar(charArr[i]);
        }

        for (int exp = 1; biggus / exp > 0; exp *= 10) {
            carolineLacroix(charArr, n, exp);
        }
    }

    private static void carolineLacroix(char[] charArr, int n, int exp) {
        int countS = 0;
        int countG = 0;
        int countR = 0;

        for (int i = 0; i < n; i++) {
            int digit = (charArr[i] / exp) % 3;
            switch (digit) {
                case (char) 0 -> countS++;
                case (char) 1 -> countG++;
                case (char) 2 -> countR++;
                default -> System.out.println("Digit: " + digit);
            }
        }

        int total = countS+countG+countR;
        int index = 0;
        for (int i = 0; i < total; i++) {
            while (countS > 0) {
                charArr[index] = 'S';
                index++;
                countS--;
            }
            while (countG > 0) {
                charArr[index] = 'G';
                index++;
                countG--;
            }
            while (countR > 0) {
                charArr[index] = 'R';
                index++;
                countR--;
            }
        }
    }
        private static char[] congo () {
            int theHat = (int) (Math.random() * 100 + Math.random() * 10);
            char[] charArr = new char[theHat];

            for (int i = 0; i < theHat; i++) {
                int theHatTwoElecticBoogaloo = (int) (Math.random() * 10 + 1) % 4;
                char rgb = 'S';

                switch (theHatTwoElecticBoogaloo) {
                    case 1 -> rgb = 'R';
                    case 2 -> rgb = 'G';
                    case 3 -> rgb = 'S';
                    default -> {
                    }
                }
                charArr[i] = rgb;
            }
            return charArr;
        }
        private static char codeChar ( char toCode){
            switch (toCode) {
                case 'S' -> toCode = 0;
                case 'G' -> toCode = 1;
                case 'R' -> toCode = 2;
                default -> {
                    break;
                }
            }
            return toCode;
        }
        private static char decodeChar ( char toDecode){
            switch (toDecode) {
                case 'a' -> toDecode = 'S';
                case 'b' -> toDecode = 'G';
                case 'c' -> toDecode = 'R';
                default -> {
                    break;
                }
            }
            return toDecode;
        }
    }

