package afleveringstuderende;

import java.util.Set;

/*
Obligatorisk afleveringsopgave
Opgaven skal afleveres som zip-fil indeholdende java-filer senest fredag den 5. april kl
08.30.
I denne opgave skal Dictionary interfacet fra 23. februar implementeres under anvendelse
af hashing.
Implementationen skal realiseres ved åben adressering med dobbel hashing som
kollisionsstrategi.
Brug h(key) = key % size som hash-funktion, hvor size er hash-tabelstørrelsen. Fra start er
hash-tabelstørrelsen 10. Tabelstørrelsen fordobles, når loadfaktoren overstiger 0,5.
Den anden hashfunktion skal være h’(key) = 7 - (key%7).
Afprøv implementationen.
Hvad er størrelsesordenen af tidskompleksiteten for de forskellige metoder.
Du kan tage udgangspunkt i implementationen, der er påbegyndt i aflevering.zip
 */
public class DictionaryDoubleHashing <K, V> implements Dictionary<K, V> {
    private Entry<K,V>[] table;
    private int size;
    private final Entry DELETED = new Entry(null,null);
    private final float DEFAULT_LOAD_CAPACITY = 0.50f;
    private int capacity;

    public DictionaryDoubleHashing(int length) { // O(1)
        table =  new Entry[length];
        size = 0;
        capacity = trim(4);
    }

    private int trim(int initilalCapacity) { // O(n)
        int capacity = 1;
        while (capacity < initilalCapacity) {
            capacity <<= 1;
        }
        return capacity;
    }

    public void clear() { // O(n)
        size = 0;
        for (Entry entry : this.table) {
            entry = null;
        }
    }

    private int hash(int hashCode) { // O(n)
        double currLoadFactor = size * DEFAULT_LOAD_CAPACITY;
        int hash = hashCode % table.length;

        if (currLoadFactor > DEFAULT_LOAD_CAPACITY) {
            rehash();
        }

        if (table[hash] == null) {
            return hash;
        }
        int inc = 0;
        while (table[hash] == DELETED) {
             hash = offset(hashCode + inc);
             ++inc;
        }
        return hash;
    }

    private int offset(int hash) {
        return 7 - (hash % 7);
    }

    private void rehash() { // O(n+k)
        int newCapacity = trim(table.length * 2 - 1);
        this.capacity = newCapacity;

        DictionaryDoubleHashing<K,V> prev = this;
        this.clear();

        for (Entry entry : prev.table) {
            K key = (K) entry.getKey();
            V value = (V) entry.getValue();
            this.put(key, value);
        }
    }

    @Override
    public V get(K key) { // O(n)
        int keyHash = hash(key.hashCode());

        if (table[keyHash] == null) return null;
        else return table[keyHash].value;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    } // O(1)

    @Override
    public V put(K key, V value) { // O(n)

        if (key == null || value == null) return null;

        if (size >= capacity * DEFAULT_LOAD_CAPACITY) {
            rehash();
        }

        int spot = hash(key.hashCode());
        Entry<K,V> spotCheck = table[spot];
        if (spotCheck != null || spotCheck != DELETED) {
            table[spot] = new Entry<>(key, value);
            size++;
        }
        return value;
    }

    @Override
    public V remove(K key) { //O(n)

        int keyHash = hash(key.hashCode());
        V value = null;

        if (table[keyHash] == null) value = null;
        else if (table[keyHash] == DELETED) {
            int offsetKeyHash = offset(hash(key.hashCode()));
            value = table[offsetKeyHash].value;
            table[offsetKeyHash] = DELETED;
        }
        else {
            value = table[keyHash].getValue();
            table[keyHash] = DELETED;
        }
        return value;
    }

    @Override
    public int size() { // O(1)
        return size;
    }


    // method only for test purpose
    public void writeOut() {
        for (int i = 0; i < table.length; i++) {
            System.out.println(i + "\t" + table[i]);
        }
    }

    public static class Entry<K,V>{
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
        public String toString(){
            return "(" +key + " , " + value + ")";
        }
    }
}
