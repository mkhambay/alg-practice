package com.khambay.alg.linkedlist;

/**
 * Time and Space - O(n)
 */
public class ReverseKNodes {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;

        while (curr != null && count != k) { // find the k+1 node
            curr = curr.next;
            count++;
        }

        if (count == k) { //reverse it only if we have enough nodes to reverse, otherwise it remains unchanged.
            ListNode prev = reverseKGroup(curr, k); // prev gets fed in from the recursion

            //Below code same as ReverseList
            curr = head;
            ListNode next = null;

            while (count > 0) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
                count--;
            }
            head = prev;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);

        ListNode reversed = reverseKGroup(node, 2);

        ListNode n = reversed;
        while(n != null) {
            System.out.print(n.val + "->");
            n = n.next;
        }
    }
}
