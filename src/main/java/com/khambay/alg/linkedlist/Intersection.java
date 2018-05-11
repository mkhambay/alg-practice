package com.khambay.alg.linkedlist;

public class Intersection {

    static class Node {
        Node next = null;
        int data = 0;

        public Node() {
        }

        public Node(int data) {
            this.data = data;
        }
    }
    
    public static class Result {
        public Node tail;
        public int size;

        public Result(Node tail, int size) {
            this.tail = tail;
            this.size = size;
        }
    }

    public static Result getTailAndSize(Node list) {
        if (list == null) return null;

        int size = 1;
        Node current = list;
        while (current.next != null) {
            size++;
            current = current.next;
        }
        return new Result(current, size);
    }

    public static Node getKthNode(Node head, int k) {
        Node current = head;
        while (k > 0 && current != null) {
            current = current.next;
            k--;
        }
        return current;
    }

    public static Node findIntersection(Node list1, Node list2) {
        if (list1 == null || list2 == null) return null;

        /* Get tail and sizes. */
        Result result1 = getTailAndSize(list1);
        Result result2 = getTailAndSize(list2);

        /* If different tail nodes, then there's no intersection. */
        if (result1.tail != result2.tail) {
            return null;
        }

        /* Set pointers to the start of each linked list. */
        Node shorter = result1.size < result2.size ? list1 : list2;
        Node longer = result1.size < result2.size ? list2 : list1;

        /* Advance the pointer for the longer linked list by the difference in lengths. */
        longer = getKthNode(longer, Math.abs(result1.size - result2.size));

        /* Move both pointers until you have a collision. */
        while (shorter != longer) { //compare the references and not value as per the problem definition
            shorter = shorter.next;
            longer = longer.next;
        }

        /* Return either one. */
        return longer;
    }

    public static void main(String[] args) {
        Node intersection = new Node(7);
        Node intersection1 = new Node(2);
        Node tail = new Node(1);

        Node list1 = new Node(3);
        list1.next = new Node(1);
        list1.next.next = new Node(5);
        list1.next.next.next = new Node(9);
        list1.next.next.next.next = intersection;
        list1.next.next.next.next.next = intersection1;
        list1.next.next.next.next.next.next = tail;

        Node list2 = new Node(4);
        list2.next = new Node(6);
        list2.next.next = intersection;
        list2.next.next.next = intersection1;
        list2.next.next.next.next = tail;

        Node intersectionPoint = findIntersection(list1, list2);
        if(intersection != null) {
            System.out.println("Found Intersection at " + intersectionPoint.data);
        }
        else {
            System.out.println("Error! Intersection not found");
        }
    }
}
