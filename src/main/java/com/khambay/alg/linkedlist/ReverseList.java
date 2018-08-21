package com.khambay.alg.linkedlist;

public class ReverseList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode current = head;
        ListNode previous = null;
        ListNode next = null;

        while(current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        head = previous;
        return head;
    }

    public static void printList(ListNode head) {
        System.out.println("Printing Linked List");

        if(head == null) {
            System.out.println("Empty list");
            return;
        }

        if(head.next == null) {
            System.out.println(head.val);
            return;
        }

        ListNode n = head;
        while(n.next != null) {
            System.out.print(n.val + " ->");
            n = n.next;
        }
        System.out.println(n.val);
    }



    public static void main(String[] args) {
        ListNode node = new ListNode(10);
        node.next = new ListNode(9);
        node.next.next = new ListNode(8);

        printList(node);

        System.out.println("Reverse it");
        ListNode reversed = reverseList(node);

        printList(reversed);
    }
}
