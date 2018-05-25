package com.khambay.alg.linkedlist;

/**
 * Time - O(n + klogn)
 * Build a min heap which takes O(n) time
 * Heapify k times which takes O(klogn) time
 * Space - O(n) for the heap
 */
import java.util.PriorityQueue;

public class MergeKSortedLists {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> queue= new PriorityQueue<>(lists.length, (l1,l2) -> Integer.compare(l1.val,l2.val));

        for (ListNode node : lists) { //O(n)
            if (node != null) {
                queue.add(node);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode p = dummy;

        while (!queue.isEmpty()) {
            p.next = queue.poll();
            p = p.next;

            if (p.next != null) { //its a list of ListNodes, keep adding them to the priority queue
                queue.add(p.next); //O(klogn)
            }
        }

        return dummy.next;
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
        ListNode[] nodes = new ListNode[3];

        ListNode node = new ListNode(1);
        node.next = new ListNode(4);
        node.next.next = new ListNode(5);
        nodes[0] = node;
        printList(node);

        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(3);
        node1.next.next = new ListNode(4);
        nodes[1] = node1;
        printList(node1);

        ListNode node2 = new ListNode(2);
        node2.next = new ListNode(6);
        nodes[2] = node2;
        printList(node2);

        System.out.println("Merged Lists");
        ListNode merged = mergeKLists(nodes);

        printList(merged);
    }
}
