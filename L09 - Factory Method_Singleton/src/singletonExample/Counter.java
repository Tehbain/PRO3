package singletonExample;

public class Counter {
    private static Counter uniqueInstance;
    private volatile int value;

    private Counter() {
        this.value = 0;
    }

    public static synchronized Counter getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Counter();
        }
        return uniqueInstance;
    }

    void count() {
        value++;
    }

    void times2() {
        value *= 2;
    }

    void zero() {
        value = 0;
    }

    public int getValue() {
        return getInstance().value;
    }
}
