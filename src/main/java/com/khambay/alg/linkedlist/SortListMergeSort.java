package com.khambay.alg.linkedlist;

/**
 * Time - O(nlogn)
 * Space - O(logn) - call a function O(log n) times, each one will cost one stack to store it so it will cost O(log n) space complexity
 */
public class SortListMergeSort {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        // step 1. cut the list to two halves
        ListNode prev = null, slow = head, fast = head;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null; //to cut the slow into a separate list

        // step 2. sort each half
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);

        // step 3. merge l1 and l2
        return merge(l1, l2);
    }

    static ListNode merge(ListNode l1, ListNode l2) {
        ListNode l = new ListNode(0), p = l;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }

        if (l1 != null)
            p.next = l1;

        if (l2 != null)
            p.next = l2;

        return l.next;
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
        ListNode node = new ListNode(4);
        node.next = new ListNode(2);
        node.next.next = new ListNode(1);
        node.next.next.next = new ListNode(3);

        printList(node);

        System.out.println("Sorted");
        ListNode sorted = sortList(node);

        printList(sorted);
    }
}
