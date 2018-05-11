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
        Map<Character, Character> charMap = new HashMap<>();
        charMap.put('(', ')');
        charMap.put('{', '}');
        charMap.put('[', ']');

        Stack<Character> charStack = new Stack();

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if(charMap.containsKey(c)) {
                //Add to stack for eval
                charStack.push(c);
            }
            else if(charMap.values().contains(c)) {
                if(!charStack.isEmpty() && charMap.get(charStack.peek()) == c) {
                    //Found the match, remove from stack
                    charStack.pop();
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
        return charStack.isEmpty();
    }

    public static void main(String[] args) {
        String test1 = "{}[]()";
        System.out.println("Testing " + test1 + " is Valid = " + isValid(test1));

        String test2 = "{[]()";
        System.out.println("Testing " + test2 + " is Valid = " + isValid(test2));

        String test3 = "##";
        System.out.println("Testing " + test3 + " is Valid = " + isValid(test3));
    }
}
