package com.khambay.alg.linkedlist;

public class RemoveNthFromEnd {

    static class ListNode {
        ListNode next = null;
        int val = 0;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null)
            return null;

        ListNode p1 = head;
        ListNode p2 = head;

        for(int i = 0; i < n; i++) {
            p1 = p1.next;
        }

        //Remove head
        if(p1 == null){
            head = head.next;
            return head;
        }

        //p1.next != null will stop it one before the nth element
        while(p1.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        //remove the nth element
        p2.next = p2.next.next;

        return head;
    }

    public static void printList(ListNode head) {
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
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        System.out.println("Printing List 1 - Remove 2nd from last in a list with 3 elements");
        printList(l1);

        l1 = removeNthFromEnd(l1, 2);
        printList(l1);

        ListNode l4 = new ListNode(1);
        l4.next = new ListNode(2);
        l4.next.next = new ListNode(3);
        System.out.println("Printing List 4 - Remove last in a list with 3 elements");
        printList(l4);

        l4 = removeNthFromEnd(l4, 1);
        printList(l4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(2);
        System.out.println("Printing List 2 - Remove 2nd from last in a list with 2 elements - remove the head");
        printList(l2);

        l2 = removeNthFromEnd(l2, 2);
        printList(l2);

        ListNode l5 = new ListNode(1);
        l5.next = new ListNode(2);
        System.out.println("Printing List 5 - Remove last in a list with 2 elements");
        printList(l5);

        l5 = removeNthFromEnd(l5, 1);
        printList(l5);

        ListNode l3 = new ListNode(1);
        System.out.println("Printing List 3 - Remove last in a list with 1 element - remove the head");
        printList(l3);

        l3 = removeNthFromEnd(l3, 1);
        printList(l3);
    }
}
