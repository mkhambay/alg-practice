package com.khambay.alg.stack;

import java.util.EmptyStackException;

public class Stack<T> {

    private class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    private Node<T> top;

    public void push(T item) {
        Node<T> t = new Node<>(item);
        t.next = top;
        top = t;
    }

    public T pop() {
        if(top == null) {
            throw new EmptyStackException();
        }
        T item = top.data;
        top = top.next;
        return item;
    }

    public T peek() {
        if(top == null) {
            throw new EmptyStackException();
        }
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public static void main(String[] args) {
        Stack<Integer> intStack = new Stack<>();
        intStack.push(1);

        Integer peek = intStack.peek();
        System.out.println("Peek = " + peek);

        Boolean isEmpty = intStack.isEmpty();
        System.out.println("isEmpty = " + isEmpty);

        intStack.pop();

        isEmpty = intStack.isEmpty();
        System.out.println("isEmpty = " + isEmpty);
    }
}
