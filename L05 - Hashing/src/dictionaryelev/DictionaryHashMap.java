package dictionaryelev;

import java.util.HashMap;
import java.util.Map;

public class DictionaryHashMap<K, V> implements Dictionary<K, V> {

    private Map<K, V>[] tabel;
    private static int N = 13;
    private static int DEFAULT_INITIAL_CAPACITY = 4;
    private static int MAXIMUM_CAPACITY = 1 << 30;
    private int capacity;
    private static double DEFAULT_LOAD_FACTOR = 0.75f;
    private double loadFactorThreshold;
    private int size = 0;


    /**
     * HashingMap constructor comment.
     */

    public DictionaryHashMap() {
        tabel = new HashMap[N];
        for (int i = 0; i < N; i++) {
            tabel[i] = new HashMap<K, V>();
        }
    }

    private int hash(int hashCode) {
        if (size >= MAXIMUM_CAPACITY * DEFAULT_LOAD_FACTOR) {
            //rehash()
        }
        if (hashCode < 0) {
            hashCode--;
        }
        return hashCode % tabel.length;
    }

    @Override
    public V get(K key) {
        int keyHash = key.hashCode() % tabel.length;
        return tabel[keyHash].get(key);
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public V put(K key, V value) {
        int keyHash = key.hashCode() % tabel.length;
        tabel[keyHash].put(key,value);
        return value;
    }

    @Override
    public V remove(K key) {
        int keyHash = key.hashCode() % tabel.length;
        V value = tabel[keyHash].get(key);
        tabel[keyHash].remove(key);
        return value;
    }

    @Override
    public int size() {
        return this.size;
    }
}
