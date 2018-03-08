package com.khambay.alg.linkedlist;

public class MergeTwoLists {

    static class ListNode {
        ListNode next = null;
        int val = 0;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode p = head;

        ListNode p1 = l1;
        ListNode p2 = l2;
        while(p1 != null && p2 != null) {
            if(p1.val < p2.val){
                p.next = p1;
                p1 = p1.next;
            }
            else{
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }

        if(p1 != null) {
            p.next = p1;
        }

        if(p2 != null) {
            p.next = p2;
        }

        return head.next;
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
        l1.next.next = new ListNode(4);
        System.out.println("Printing List 1");
        printList(l1);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        l2.next.next.next = new ListNode(5);
        System.out.println("Printing List 1");
        printList(l2);

        ListNode merged = mergeTwoLists(l1, l2);
        printList(merged);
    }
}
