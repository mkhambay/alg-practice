package com.khambay.alg.design;

import java.util.HashMap;
import java.util.Map;

/**
 * Uses a HashMap for quick key based lookup
 * Uses a Doubly Linked List - helps with insertion, removal and doubly helps with removal from middle
 * Head and Tail Pointers - help with keeping track for Least Recently Used - Head - recent and Tail - least recent
 *
 * Time - O(1)
 * Doubly linked list - Insertion and Deletion is O(1)
 * Hash Map - Insertion, Deletion and Searching is O(1)
 */
public class LRUCache {

    private class Node {
        int key, value; //key and value both saved in node
        Node prev, next; //double linked list so that we can remove a element from middle if needed

        Node(int k, int v) {
            this.key = k;
            this.value = v;
        }

        Node() {
            this(0, 0);
        }
    }

    private int capacity, count;
    //Key - Key
    //Value - Node
    private Map<Integer, Node> map; //to enable look up by key - this would be very slow if just linked list
    private Node head, tail; //to keep track of least recently used - head points to recently used, tail points to least recently used

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.count = 0;

        map = new HashMap<>();

        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node node = map.get(key);
        if(node == null) {
            return -1;
        }
        moveToHead(node); //move this node to front since it has just been accessed
        return node.value;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if(node == null) { //insert new
            node = new Node(key, value);
            map.put(key, node);
            addToHead(node);
            count++;
        }
        else { //update existing
            node.value = value;
            moveToHead(node); //move this node to front since it has just been accessed
        }

        //If capacity reached, remove last used node, the node at the tail.
        if(count > capacity) {
            Node toDel = tail.prev;
            remove(toDel);
            map.remove(toDel.key);
            count--;
        }
    }

    private void moveToHead(Node node){
        remove(node);
        addToHead(node);
    }

    private void addToHead(Node node){
        Node after = head.next;
        head.next = node;
        node.prev = head;
        node.next = after;
        after.prev = node;
    }

    private void remove(Node node){
        Node before = node.prev, after = node.next;
        before.next = after;
        after.prev = before;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache( 2 /* capacity */ );

        cache.put(1, 1);
        cache.put(2, 2);
        int one = cache.get(1);       // returns 1
        System.out.println("Get 1 = " + one);

        cache.put(3, 3);    // evicts key 2
        int two = cache.get(2);       // returns -1 (not found)
        System.out.println("Get 2 = " + two);

        cache.put(4, 4);    // evicts key 1
        one = cache.get(1);       // returns -1 (not found)
        System.out.println("Get 1 = " + one);

        int three = cache.get(3);       // returns 3
        System.out.println("Get 3 = " + three);
        int four = cache.get(4);       // returns 4
        System.out.println("Get 4 = " + four);
    }
}
