package com.khambay.alg.queue;

public class QueueUsingStack {

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

    private Stack stackNewest = new Stack();
    private Stack stackOldest = new Stack();

    public void push(int value) {
        stackNewest.push(value);
    }

    public int peek() throws Exception {
        shiftStacks();
        return stackOldest.peek();
    }

    public int pop() throws Exception {
        shiftStacks();
        return stackOldest.pop();
    }

    private void shiftStacks() throws Exception {
        if (stackOldest.isEmpty()) {
            while (!stackNewest.isEmpty()) {
                stackOldest.push(stackNewest.pop());
            }
        }
    }

    public void printStackNewest() {
        System.out.print("New Stack -> ");
        stackNewest.printStack();
    }

    public void printStackOldest() {
        System.out.print("Old Stack -> ");
        stackOldest.printStack();
    }

    public static void main(String[] args) throws Exception {
        QueueUsingStack minStack = new QueueUsingStack();

        minStack.push(6);
        minStack.push(4);
        minStack.push(3);
        minStack.push(2);
        minStack.push(8);
        minStack.push(9);
        minStack.push(1);
        minStack.push(5);
        minStack.printStackNewest();
        minStack.printStackOldest();

        System.out.println("Pop data = " + minStack.pop());

        minStack.printStackNewest();
        minStack.printStackOldest();

        System.out.println("Peek data = " + minStack.peek());

        System.out.println("Push data");
        minStack.push(10);
        minStack.printStackNewest();
        minStack.printStackOldest();
    }
}
