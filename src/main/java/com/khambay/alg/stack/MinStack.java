package com.khambay.alg.stack;

import com.khambay.alg.queue.QueueUsingStack;

public class MinStack {

    public class Stack {

        class Node {
            int data;
            Node next;

            public Node(int data) {
                this.data = data;
            }
        }

        private Node top;

        public Stack() {}

        public Stack(int data) {
            Node n = new Node(data);
            top = n;
        }

        public void push(int data) {
            Node n = new Node(data);
            n.next = top;
            top = n;
        }

        public int pop() throws Exception {
            if(top == null) {
                throw new Exception("Empty stack");
            }
            Node n = top;
            top = top.next;
            return n.data;
        }

        public int peek() throws Exception {
            if(top == null) {
                throw new Exception("Empty stack");
            }
            return top.data;
        }

        public boolean isEmpty() {
            return top == null;
        }

        public void printStack() {
            if(!isEmpty()) {
                Node n = top;
                System.out.print("[");
                while (n.next != null) {
                    System.out.print(n.data + ",");
                    n = n.next;
                }
                System.out.println(n.data + "]");
            }
            else {
                System.out.println("Nothing to print. Stack is empty!");
            }
        }
    }

    private Stack stackData = new Stack();
    private Stack stackMin = new Stack();

    public void push(int data) throws Exception {
        if(data <= min()) {
            stackMin.push(data);
        }
        stackData.push(data);
    }

    public int pop() throws Exception {
        int popData = stackData.pop();
        if(popData == min()) {
            stackMin.pop();
        }
        return popData;
    }

    public int min() throws Exception {
        if(stackMin.isEmpty()) {
            return Integer.MAX_VALUE;
        }
        else {
            return stackMin.peek();
        }
    }

    public void printStackData() {
        stackData.printStack();
    }

    public void printStackMin() {
        stackMin.printStack();
    }

    public static void main(String[] args) throws Exception {
        MinStack minStack = new MinStack();

        minStack.push(6);
        minStack.push(4);
        minStack.push(3);
        minStack.push(2);
        minStack.push(8);
        minStack.push(9);
        minStack.push(1);
        minStack.push(5);
        minStack.printStackData();
        minStack.printStackMin();

        System.out.println("Pop");
        minStack.pop();
        minStack.printStackData();
        minStack.printStackMin();

        System.out.println("Pop min");
        minStack.pop();
        minStack.printStackData();
        minStack.printStackMin();

        System.out.println("MinStack 2");

        MinStack minStack2 = new MinStack();
        minStack2.push(0);
        minStack2.push(1);
        minStack2.push(0);
        minStack2.printStackData();
        minStack2.printStackMin();

        System.out.println("getMin=" + minStack2.min());
        minStack2.pop();
        System.out.println("getMin=" + minStack2.min());
        minStack2.printStackData();
        minStack2.printStackMin();
    }
}
