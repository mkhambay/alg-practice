package com.khambay.alg.ood;

import java.util.ArrayList;

public class HashTableCustom<K, V> {

    private static class LinkedListNode<K, V> {
        public LinkedListNode<K, V> next;
        public LinkedListNode<K, V> prev;
        public K key;
        public V value;

        public LinkedListNode(K k, V v) {
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

    private ArrayList<LinkedListNode<K, V>> arr;

    public HashTableCustom(int capacity) {
        /* Create list of linked lists. */
        arr = new ArrayList<>();
        arr.ensureCapacity(capacity);
        for (int i = 0; i < capacity; i++) {
            arr.add(null);
        }
    }

    public V put(K key, V value) {
        LinkedListNode<K, V> node = getNodeForKey(key);

        //UPDATE
        if (node != null) {
            V oldValue = node.value;
            node.value = value;
            return oldValue;
        }

        //INSERT
        node = new LinkedListNode<>(key, value);
        int index = getIndexForKey(key);
        if (arr.get(index) != null) {
            node.next = arr.get(index);
            node.next.prev = node;
        }
        //set head
        arr.set(index, node);
        return null;
    }

    /* Remove node for key. */
    public V remove(K key) {
        LinkedListNode<K, V> node = getNodeForKey(key);
        if (node == null) {
            return null;
        }

        //Relink previous node
        if (node.prev != null) {
            node.prev.next = node.next;
        }
        else {
            //Remove head
            int hashKey = getIndexForKey(key);
            //set head to next
            arr.set(hashKey, node.next);
        }

        //Relink next node
        if (node.next != null) {
            node.next.prev = node.prev;
        }
        return node.value;
    }

    public V get(K key) {
        if (key == null) return null;
        LinkedListNode<K, V> node = getNodeForKey(key);
        return node == null ? null : node.value;
    }

    private LinkedListNode<K, V> getNodeForKey(K key) {
        int index = getIndexForKey(key);
        LinkedListNode<K, V> current = arr.get(index);
        while (current != null) {
            if (current.key == key) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    /**
     * Returns 0, 1, or 2
     * @param key
     * @return
     */
    public int getIndexForKey(K key) {
        return Math.abs(key.hashCode() % arr.size());
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
