package com.khambay.alg.stack;

public class SortStack {

    public static class Stack {

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

        public void sort() throws Exception {
            Stack r = new Stack();
            while(!this.isEmpty()) {
                int tmp = this.pop();
                while(!r.isEmpty() && r.peek() > tmp) {
                    this.push(r.pop());
                }
                r.push(tmp);
            }

            while (!r.isEmpty()) {
                this.push(r.pop());
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Stack sortStack = new Stack();

        sortStack.push(4);
        sortStack.push(10);
        sortStack.push(5);
        sortStack.push(1);
        sortStack.push(3);
        sortStack.push(2);
        sortStack.printStack();

        sortStack.sort();
        sortStack.printStack();
    }
}
