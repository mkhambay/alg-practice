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
        char sign = '+'; //default as expression string contains only non-negative integers

        for(int i = 0; i < s.length(); i++){
            if(Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            }

            if(i == s.length() - 1 //if its last digit, go here too
                    || !Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ') {
                switch(sign) {
                    case '-':
                        stack.push(-num);
                        break;
                    case '+':
                        stack.push(num);
                        break;
                    case '*':
                        stack.push(stack.pop()*num);
                        break;
                    case '/':
                        stack.push(stack.pop()/num);
                        break;
                }
                sign = s.charAt(i);
                num = 0;
            }
        }

        int result = 0;
        for(int i : stack){ //sum up the stack based on operator precedence, * and / are already done. Leaving - and +
            result += i;
        }
        return result;
    }

    public static void main(String[] args) {
        String str1 = "3+2*2";
        String str2 = " 3/2 ";
        String str3 = " 3+5 / 2 ";
        String str4 = "20*10";
        System.out.println("Str 1 " + str1 + " = " + calculate(str1));
        System.out.println("Str 2 " + str2 + " = " + calculate(str2));
        System.out.println("Str 3 " + str3 + " = " + calculate(str3));
        System.out.println("Str 4 " + str4 + " = " + calculate(str4));
    }
}
