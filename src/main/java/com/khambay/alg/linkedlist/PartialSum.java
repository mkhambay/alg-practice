package com.khambay.alg.linkedlist;

public class PartialSum {

    static class Node {
        Node next = null;
        int data = 0;

        public Node() {
        }

        public Node(int data) {
            this.data = data;
        }
    }

    public Node addLists(Node l1, Node l2, int carry) {
        if(l1 == null && l2 == null && carry == 0) {
            return null;
        }

        Node result = new Node();
        int value = carry;
        if(l1 != null) {
            value += l1.data;
        }
        if(l2 != null) {
            value += l2.data;
        }

        result.data = value % 10; /* Get second digit */

        //Recurse
        if(l1 != null || l2 != null) {
            Node more = addLists(l1 == null? null : l1.next,
                                    l2 == null? null : l2.next,
                                    value >= 10 ? 1 : 0);

            result.next = more;
        }
        return result;
    }

    public void printList(Node n) {
        Node it = n;
        StringBuilder buf = new StringBuilder();

        if(it.next == null) {
            buf.append(it.data);
        }
        else {
            while (it.next != null) {
                buf.append(it.data + " -> ");
                it = it.next;
            }
            buf.append(it.data);
        }
        System.out.println("LinkedList = " + buf.toString());
    }


    public static void main(String args[]) {
        PartialSum partialSum = new PartialSum();

        //Create list
        //7 -> 1 -> 6
        //5 -> 9 -> 2
        Node l1 = new Node(7);
        l1.next = new Node(1);
        l1.next.next = new Node(6);
        System.out.println("Printing l1");
        partialSum.printList(l1);

        Node l2 = new Node(5);
        l2.next = new Node(9);
        l2.next.next = new Node(2);
        System.out.println("Printing l2");
        partialSum.printList(l2);

        Node result = partialSum.addLists(l1, l2, 0);
        System.out.println("Printing result");
        partialSum.printList(result);
    }

}
