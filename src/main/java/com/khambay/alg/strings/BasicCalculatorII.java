package com.khambay.alg.strings;

import java.util.Stack;

/**
 * Time - O(n)
 * Space - O(n)
 */
public class BasicCalculatorII {

    public static int calculate(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char sign = '+';
        for(int i = 0; i < s.length(); i++){
            if(Character.isDigit(s.charAt(i))) {
                int temp = s.charAt(i) - '0';
                num = num * 10 + s.charAt(i) - '0';
            }
            if((!Character.isDigit(s.charAt(i)) && ' ' != s.charAt(i)) || i == s.length() - 1) {
                if(sign == '-') {
                    stack.push(-num);
                }
                if(sign == '+') {
                    stack.push(num);
                }
                if(sign == '*') {
                    stack.push(stack.pop() * num);
                }
                if(sign == '/') {
                    stack.push(stack.pop() / num);
                }
                sign = s.charAt(i);
                num = 0;
            }
        }

        int re = 0;
        for(int i : stack){
            re += i;
        }
        return re;
    }

    public static void main(String[] args) {
        String str1 = "5-2*2";
        String str2 = " 3/2 ";
        String str3 = " 3+5 / 2 ";
        System.out.println("Str 1 " + str1 + " = " + calculate(str1));
        System.out.println("Str 2 " + str2 + " = " + calculate(str2));
        System.out.println("Str 3 " + str3 + " = " + calculate(str3));
    }
}
