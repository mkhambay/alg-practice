package com.khambay.alg.queue;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

public class Queue<T> {

    private class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    private Node<T> head;
    private Node<T> tail;

    public void push(T item) {
        Node<T> t = new Node<>(item);

        if(tail != null) {
            tail.next = t;
        }
        tail = t;

        if(head == null) {
            head = tail;
        }
    }

    public T pop() {
        if(head == null) {
            throw new NoSuchElementException();
        }
        T data = head.data;
        head = head.next;

        if(head == null) {
            tail = null;
        }
        return data;
    }


    public T peek() {
        if(head == null) {
            throw new EmptyStackException();
        }
        return head.data;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public static void main(String[] args) {
        Queue<Integer> myQueue = new Queue<>();
        myQueue.push(1);

        Integer peek = myQueue.peek();
        System.out.println("Peek = " + peek);

        Boolean isEmpty = myQueue.isEmpty();
        System.out.println("isEmpty = " + isEmpty);

        myQueue.pop();

        isEmpty = myQueue.isEmpty();
        System.out.println("isEmpty = " + isEmpty);
    }
}
