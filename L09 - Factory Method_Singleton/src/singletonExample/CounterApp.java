package singletonExample;

public class CounterApp {
    static Counter counterSingleton = Counter.getInstance();
    public static void main(String[] args) {
        counterSingleton.getInstance();
        System.out.println(counterSingleton.getInstance());
        System.out.println(counterSingleton.getValue());
        counterSingleton.count();
        counterSingleton.count();
        System.out.println(counterSingleton.getValue());
        counterSingleton.times2();
        System.out.println(counterSingleton.getValue());
        counterSingleton.zero();
        System.out.println(counterSingleton.getValue());
        System.out.println(counterSingleton.getInstance());
    }
}
