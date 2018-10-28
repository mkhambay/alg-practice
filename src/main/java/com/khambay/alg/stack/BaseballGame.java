package com.khambay.alg.stack;

import java.util.Stack;

/**
 * Similar to ReversePolishNotation
 *
 * Time and Space - O(n)
 */
public class BaseballGame {

    public static int calPoints(String[] ops) {
        if(ops == null || ops.length < 1) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();

        String operations = "+CD";

        for(String s : ops) {
            if(!operations.contains(s)) {
                stack.push(Integer.valueOf(s));
            }
            else {
                int index = operations.indexOf(s);
                switch(index) {
                    case 0:
                        int a = stack.pop();
                        int sum = a + stack.peek();
                        stack.push(a);
                        stack.push(sum);
                        break;
                    case 1:
                        stack.pop();
                        break;
                    case 2:
                        stack.push(stack.peek() * 2);
                        break;
                }
            }
        }

        int result = 0;
        for(int i : stack) {
            result += i;
        }
        return result;
    }

    public static void main(String[] args) {
        String[] ops = {"5","2","C","D","+"};
        System.out.println("Call points = " + calPoints(ops));
    }

}
