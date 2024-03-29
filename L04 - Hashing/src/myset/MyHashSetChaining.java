package myset;

import java.util.LinkedList;
import java.util.function.Function;

public class MyHashSetChaining<E> implements MySet<E> {
    // The number of elements in the set
    private int size = 0;

    // Hash table is an array with each cell that is a linked list
    private Node<E>[] table;

    public MyHashSetChaining(int bucketsLength) {
        table = (Node<E>[])new Node[bucketsLength];
        size = 0;
    }

    /** Hash function */
    private int hash(int hashCode) {
        double loadFactorThreshold = 0.75;
        double capacityCap = (size+1) * 0.75;
        if (size >= capacityCap * loadFactorThreshold) {
            //reHash();
        }
        if (hashCode < 0) {
            hashCode = -hashCode;
        }
        return hashCode % (table.length);
    }

    private void reHash() {
        int newCapacity = table.length * 2 + 1;
        Node<E>[] oldBoy = table;
        size = 0;
        table = (Node<E>[]) new Node[newCapacity];

        for (Node<E> node : oldBoy) {
            while (node != null && node.next != null) {
                table[size] = node;
                node = node.next;
                size++;
            }
        }
        size = 0;
    }

    @Override /** Remove all elements from this set */
    public void clear() {
        size = 0;
        for (int i = 0; i < table.length - 1; i++) {
            if (table[i] != null) {
                table[i].next = null;
                table[i] = null;
            }
        }
    }

    @Override /** Return true if the element is in the set */
    public boolean contains(E e) {
        int bucketIndex = hash(e.hashCode());
        Node<E> current = table[bucketIndex];
        boolean found = false;
        while (!found && current != null) {
            if (current.data.equals(e)) {
                found = true;
            } else {
                current = current.next;
            }
        }
        return found;
    }

    @Override /** Add an element to the set */
    public boolean add(E e) {

        int bucketIndex = hash(e.hashCode());
        Node<E> current = table[bucketIndex];
        boolean found = false;
        while (!found && current != null) {
            if (current.data.equals(e)) {
                found = true;
                // Already in the set
            } else {
                current = current.next;
            }
        }
        if (!found) {
            Node newNode = new Node();
            newNode.data = e;
            newNode.next = table[bucketIndex];
            table[bucketIndex] = newNode;
            size++;
        }
        return !found;


    }

    @Override /** Remove the element from the set */
    public boolean remove(E e) {
        boolean found = contains(e);
        if (found == false) return found = false;

        int bucketIndex = hash(e.hashCode());
        Node<E> current = table[bucketIndex];

        if (current.data.equals(e)) {
            table[bucketIndex] = current.next;
            current = null;
            size--;
        }

        while (current != null) {
            if (current.data.equals(e)) {
                table[bucketIndex] = current.next;
                current.next = current.next.next;
                current = null;
                size--;
                return found;
            } else {
                current = current.next;
            }
        }
        return found = false;
    }

    @Override /** Return true if the set contains no elements */
    public boolean isEmpty() {
        return size == 0;
    }

    @Override /** Return the number of elements in the set */
    public int size() {
        return size;
    }

    // method only for test purpose
    void writeOut() {
        for (int i = 0; i < table.length; i++) {
            Node<E> temp = table[i];
            if (temp != null) {
                System.out.print(i + "\t");
                while (temp != null) {
                    System.out.print(temp.data + "\t");
                    temp = temp.next;
                }
                System.out.println();
            }
        }
    }
   private class Node<E>{
        public E data;
        public Node<E> next;
    }

}
