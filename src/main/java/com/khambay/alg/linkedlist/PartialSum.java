package com.khambay.alg.linkedlist;

/**
 * Time and Space - O(n) - Space due to recursive call
 */
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

        int sum = carry;

        if(l1 != null) sum += l1.data;
        if(l2 != null) sum += l2.data;

        Node result = new Node(sum % 10); //get the 2nd digit
        carry = sum >= 10 ? 1 : 0;

        if(l1 != null || l2 != null) { //one list could be shorter than another, thats why null check with OR
            result.next = addLists(l1 == null ? null : l1.next,
                                    l2 == null ? null : l2.next,
                                    carry);
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
