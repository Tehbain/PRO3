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
    private float DEFAULT_LOAD_CAPACITY = 0.50f;
    private int capacity;

    public DictionaryDoubleHashing(int length) {
        table =  new Entry[length];
        size = 0;
        capacity = trim(4);
    }

    private int trim(int initilalCapacity) {
        int capacity = 1;
        while (capacity < initilalCapacity) {
            capacity <<= 1;
        }
        return capacity;
    }

    public void clear() {
        size = 0;
        for (Entry entry : this.table) {
            entry = null;
        }
    }

    private int hash(int hashCode) {
        double currLoadFactor = size * DEFAULT_LOAD_CAPACITY;
        int hash = hashCode % table.length;

        if (currLoadFactor > DEFAULT_LOAD_CAPACITY) {
            rehash();
        }

        if (table[hash] == null) {
            return hash;
        }
        while (table[hash] == DELETED) {
             hash = offset(hashCode);
        }
        return hash;
    }

    private int offset(int hash) {
        return 7 - (hash % 7);
    }

    private void rehash() {
        int newCapacity = trim(table.length * 2 - 1); //TODO
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
    public V get(K key) {
        int keyHash = hash(key.hashCode());
        return table[keyHash].value;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public V put(K key, V value) {

        if (this.get(key) != null) {
            int hash = hash(key.hashCode());
            table[hash] = new Entry<>(key, value);
            return value;
        }

        if (size >= capacity * DEFAULT_LOAD_CAPACITY) {
            rehash();
        }

        int index = hash(key.hashCode());
        Entry<K,V> newEntry = new Entry<K, V>(key, value);
        table[index] = newEntry;
        size++;

        return value;
    }

    @Override
    public V remove(K key) {

        int keyHash = hash(key.hashCode());
        V value = table[keyHash].getValue();
        table[keyHash] = DELETED;

        return value;
    }

    @Override
    public int size() {
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
