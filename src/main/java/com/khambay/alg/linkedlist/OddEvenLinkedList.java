package com.khambay.alg.linkedlist;

/**
 * Time - O(n)
 * Space - O(1)
 */
public class OddEvenLinkedList {

    static class ListNode {
        ListNode next = null;
        int val = 0;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode oddHead = head;
        ListNode oddTail = head;
        ListNode evenHead = head.next;
        ListNode evenTail = head.next;

        while(evenTail != null && evenTail.next != null) {
            oddTail.next = evenTail.next;
            oddTail = oddTail.next;
            evenTail.next = oddTail.next;
            evenTail = evenTail.next;
        }
        //Combine odd and even
        oddTail.next = evenHead;
        return oddHead;
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
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);
        printList(l1);

        ListNode oddEven = oddEvenList(l1);
        printList(oddEven);

    }
}
