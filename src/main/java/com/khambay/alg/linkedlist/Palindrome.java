package com.khambay.alg.linkedlist;

import java.util.Stack;

/**
 * Time and Space - O(n)
 */
public class Palindrome {
    
    static class Node {
        Node next = null;
        int data = 0;

        public Node() {
        }

        public Node(int data) {
            this.data = data;
        }
    }

    public static boolean isPalindrome(Node head) {
        if(head == null || head.next == null) {
            return true;
        }

        Node fast = head;
        Node slow = head;

        Stack<Integer> stack = new Stack<>();

        while (fast != null && fast.next != null) {
            stack.push(slow.data);
            slow = slow.next;
            fast = fast.next.next;
        }

        /* Has odd number of elements, so skip the middle */
        if (fast != null) {
            slow = slow.next;
        }

        while (slow != null && !stack.isEmpty()) {
            Integer top = stack.pop();
            if (top != slow.data) {
                return false;
            }
            slow = slow.next;
        }
        return true;
    }

    public static void main(String[] args) {
        Node head = new Node(8);
        head.next = new Node(9);
        head.next.next = new Node(10);
        head.next.next.next = new Node(9);
        head.next.next.next.next = new Node(8);

        System.out.println(isPalindrome(head));
    }
}
