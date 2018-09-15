package com.khambay.alg.ood;

import java.util.ArrayList;

/**
 * Uses Doubly Linked List for all the data nodes
 * And ArrayList of LinkedLists to store by buckets
 */
public class HashTableCustom<K, V> {

    class Node<K, V> {
        K key;
        V value;
        Node<K, V> next;
        Node<K, V> prev;

        public Node(K k, V v) {
            key = k;
            value = v;
        }

        public String printForward() {
            String data = "(" + key + "," + value + ")";
            if (next != null) {
                return data + "->" + next.printForward();
            } else {
                return data;
            }
        }
    }

    ArrayList<Node<K, V>> arr;

    public HashTableCustom(int capacity) {
        /* Create list of linked lists. */
        arr = new ArrayList<>();
        arr.ensureCapacity(capacity);
        for (int i = 0; i < capacity; i++) {
            arr.add(null);
        }
    }

    public V get(K key) {
        if (key == null) return null;
        Node<K, V> node = getNodeForKey(key);
        return node == null ? null : node.value;
    }

    public V put(K key, V value) {
        Node<K, V> node = getNodeForKey(key);

        //UPDATE
        if (node != null) {
            V oldValue = node.value;
            node.value = value;
            return oldValue;
        }

        //INSERT
        node = new Node<>(key, value);
        int index = getIndexForKey(key);
        if (arr.get(index) != null) { //existing node, add to head
            //add node to head
            node.next = arr.get(index);
            node.next.prev = node;
        }
        //set head
        arr.set(index, node); //does a set and not an add - set replaces
        return null;
    }

    /* Remove node for key. */
    public V remove(K key) {
        Node<K, V> node = getNodeForKey(key);
        if (node == null) {
            return null;
        }

        //Relink previous node
        if (node.prev != null) {
            node.prev.next = node.next;
        }
        else {
            //Remove head
            int index = getIndexForKey(key);
            //set head to next
            arr.set(index, node.next);
        }

        //Relink next node
        if (node.next != null) {
            node.next.prev = node.prev;
        }
        return node.value;
    }

    private int getIndexForKey(K key) {
        return Math.abs(key.hashCode() % arr.size());
    }

    private Node<K, V> getNodeForKey(K key) {
        int index = getIndexForKey(key);
        Node<K, V> current = arr.get(index);

        while (current != null) {
            if (current.key == key) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public void printTable() {
        for (int i = 0; i < arr.size(); i++) {
            String s = arr.get(i) == null ? "" : arr.get(i).printForward();
            System.out.println(i + ": " + s);
        }
    }

    public static class Dummy {
        private String name;
        private int age;
        public Dummy(String n, int a) {
            name = n;
            age = a;
        }

        @Override
        public String toString() {
            return "(" + name + ", " + age + ")";
        }

        public int getAge() {
            return age;
        }

        public String getName() {
            return name;
        }
    }

    public static void main(String[] args) {
        Dummy bob = new Dummy("Bob", 20);
        Dummy jim = new Dummy("Jim", 25);
        Dummy alex = new Dummy("Alex", 30);
        Dummy alexTwin = new Dummy("Alex", 35);
        Dummy tim = new Dummy("Tim", 35);
        Dummy maxwell = new Dummy("Maxwell", 40);
        Dummy john = new Dummy("John", 45);
        Dummy julie = new Dummy("Julie", 50);
        Dummy christy = new Dummy("Christy", 55);
        Dummy tim2 = new Dummy("Tim", 100); // This should replace the first "tim"

        Dummy[] dummies = {bob, jim, alex, alexTwin, tim, maxwell, john, julie, christy, tim2};

        HashTableCustom<String, Dummy> hash = new HashTableCustom<String, Dummy>(3);
        for (Dummy d : dummies) {
            System.out.println(hash.put(d.getName(), d));
        }

        hash.printTable();

        for (Dummy d : dummies) {
            String name = d.getName();
            Dummy dummy = hash.get(name);
            if (dummy == null) {
                System.out.println("Dummy named " + name + ": not found");
            } else {
                System.out.println("Dummy named " + name + ": " + dummy.toString());
            }
            Dummy d2 = hash.remove(name);
            if (d2 == null) {
                System.out.println("Dummy remove named " + name + ": " + "not found");
            } else {
                System.out.println("Dummy removed named " + name + ": " + d2.toString());
            }
        }
    }
}
