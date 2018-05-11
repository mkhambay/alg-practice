package com.khambay.alg.stack;

public class ReversePolishNotation {

    static class Stack <T> {

        class StackNode {
            T val;
            StackNode next;

            public StackNode(T val) {
                this.val = val;
            }
        }

        StackNode head;

        public void push(T c) {
            StackNode s = new StackNode(c);
            s.next = head;
            head = s;
        }

        public T pop() {
            if(head != null) {
                StackNode node = head;
                head = head.next;
                return node.val;
            }
            return null;
        }

        public T peek() {
            if(head == null) {
                return null;
            }
            else {
                return head.val;
            }
        }

        public boolean isEmpty() {
            return head == null;
        }
    }

    public static int evalRPN(String[] tokens) {
        String operators = "+-*/";
        Stack<Integer> stack = new Stack<>();

        for(String t : tokens){
            if(!operators.contains(t)) { //its a number, add to stack
                stack.push(Integer.valueOf(t));
            }
            else {//evaluate the operator and put interium result back on stack for further processing
                //As its a stack the values are in reverse, value of b is before a in the stack
                int b = stack.pop();
                int a = stack.pop();
                int index = operators.indexOf(t);
                switch(index) {
                    case 0:
                        stack.push(a+b);
                        break;
                    case 1:
                        stack.push(a-b);
                        break;
                    case 2:
                        stack.push(a*b);
                        break;
                    case 3:
                        stack.push(a/b);
                        break;
                }
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String[] tokens = {"2", "1", "+", "3", "*"};
        System.out.println("Eval=" + evalRPN(tokens));

        String[] tokens1 = {"4", "13", "5", "/", "+"};
        System.out.println("Eval=" + evalRPN(tokens1));
    }
}
