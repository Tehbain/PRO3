public class opg4 {
    
    /*
    Lav en metode der kan beregne det n’te tal i fibnoacci talfølgen. Metoden skal
    have lineær størrelsesorden af tidskompleksitet.
     */
    public static void main(String[] args) {
        System.out.println(fibIt(8));
    }
    static int fibIt(int n) {
        
        int fib0 = 0;
        int fib1 = 1;
        int fib2 = 1;

        if (n == 0) {
            return fib0;
        } else if (n == 1) {
            return fib1;
        } else if (n == 2) {
            return fib2;
        }

        for (int i = 3; i <= n; i++) {
            fib0 = fib1;
            fib1 = fib2;
            fib2 = fib0 + fib1;
        }
        return fib2;
    }
    
}
