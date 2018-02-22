package com.khambay.alg.stack;

import java.util.EmptyStackException;

public class MyStack<T> {

    private static class StackNode<T> {
        private T data;
        private StackNode<T> next;

        public StackNode(T data) {
            this.data = data;
        }
    }

    private StackNode<T> top;

    public T pop() {
        if(top == null) {
            throw new EmptyStackException();
        }
        T item = top.data;
        top = top.next;
        return item;
    }

    public void push(T item) {
        StackNode<T> t = new StackNode<>(item);
        t.next = top;
        top = t;
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
        MyStack<Integer> intStack = new MyStack<>();
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
