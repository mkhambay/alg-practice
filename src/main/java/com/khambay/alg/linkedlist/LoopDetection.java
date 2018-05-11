package com.khambay.alg.linkedlist;

public class LoopDetection {

    static class Node {
        Node next = null;
        int data = 0;

        public Node() {
        }

        public Node(int data) {
            this.data = data;
        }
    }
    
    public static Node detectLoop(Node head) {
        Node slow = head;
        Node fast = head;

        // Find meeting point
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) { //collision point
                break;
            }
        }

        // Error check - there is no meeting point, and therefore no loop
        if (fast == null || fast.next == null) {
            return null;
        }

		/* Move slow to Head. Keep fast at Meeting Point. Each are k steps
		/* from the Loop Start. If they move at the same pace, they must
		 * meet at Loop Start. */
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        // Both now point to the start of the loop.
        return fast;
    }

    public static void main(String[] args) {
        Node intersection = new Node(7);
        Node intersection1 = new Node(2);
        Node intersection2 = new Node(6);
        Node tail = new Node(1);

        Node list1 = new Node(3);
        list1.next = new Node(1);
        list1.next.next = new Node(5);
        list1.next.next.next = intersection;
        list1.next.next.next.next = intersection1;
        list1.next.next.next.next.next = intersection2;
        list1.next.next.next.next.next.next = intersection;

        Node loop = detectLoop(list1);
        if (loop == null) {
            System.out.println("No Cycle.");
        } else {
            System.out.println("Found cycle at " + loop.data);
        }
    }
}
