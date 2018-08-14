package com.khambay.alg.stack;

import java.util.HashMap;
import java.util.Map;

public class ValidParentheses {

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

        public void pop() {
            if(head != null) {
                head = head.next;
            }
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


    public static boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');

        Stack<Character> stack = new Stack();

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if(map.containsKey(c)) { //check valid char
                //Add to stack for eval
                stack.push(c);
            }
            else if(map.values().contains(c)) { //check valid char
                if(!stack.isEmpty() && map.get(stack.peek()) == c) {
                    //Found the match, remove from stack
                    stack.pop();
                }
                else {
                    return false;
                }
            }
            else {
                return false;
            }
        }
        //At this point if everything matched up, the stack should be empty
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String test0 = "{[]}";
        System.out.println("Testing " + test0 + " is Valid = " + isValid(test0));

        String test1 = "{}[]()";
        System.out.println("Testing " + test1 + " is Valid = " + isValid(test1));

        String test2 = "{[]()";
        System.out.println("Testing " + test2 + " is Valid = " + isValid(test2));

        String test3 = "##";
        System.out.println("Testing " + test3 + " is Valid = " + isValid(test3));
    }
}
