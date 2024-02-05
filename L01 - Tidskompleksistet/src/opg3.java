import java.util.Arrays;

public class opg3 {

    /*
    Algoritme prefixAverage.
Du skal lave en metode der givet et array af heltal beregner prefix gennemsnittet
af tallene i arrayet.
Prefix gennemsnittet af et array er et nyt array hvor indeks i indeholder
gennemsnittet af tallene på indeksplads 0 til i, i det oprindelige array. Dette kan
illustreres med nedenstående eksempel:
Givet arrayet
{5, 10, 5, 6, 4, 9, 8}
Er prefixarrayet
{5.0, 7.5, 6.667, 6.5, 6.0, 6.5, 6.714}
Metoden har følgende signatur:
public static double[] prefixAverage(int[] inputTal)
Programmer metoden så den får den mindst mulige tidskompleksitet.
     */

    public static void main(String[] args) {
        int[] arr = new int[]{5,10,5,6,4,9,8};

        System.out.println(Arrays.toString(prefixAverage(arr)));
    }

    static double[] prefixAverage(int[] input) {
        double[] temp = new double[input.length - 1];
        double sum = 0;
        for (int i = 1; i < input.length; i++) {
            sum += input[i-1];
            temp[i-1] = sum/i;
        }
        return temp;
    }

}
