package com.khambay.alg.linkedlist;


import java.util.HashSet;

/**
 * Singly Linked List
 * @author Mandeep Khambay
 * @since 01-24-2018
 */
public class LinkedList {

    class Node {
        Node next = null;
        int data;

        public Node(int data){
            this.data = data;
        }
    }

    private Node head;

    public LinkedList(int data) {
        head = new Node(data);
    }

    public void pushFront(int data) {
        Node front = new Node(data);
        front.next = head;
        head = front;
    }

    public void popFront() throws Exception {
        if(head == null)
            throw new Exception("Error: Empty list");
        head = head.next;
    }

    public void pushBack(int data) {
        Node tail = new Node(data);
        Node it = head;

        if(head == null) {
            head = tail;
        }
        else {
            while(it.next != null) {
                it = it.next;
            }
            it.next = tail;
        }
    }

    public Node topFront() {
        return head;
    }

    public Node topBack() throws Exception {
        if(head == null)
            throw new Exception("Error: Empty list");
        Node it = head;
        while(it.next != null) {
            it = it.next;
        }
        return it;
    }

    public void popBack() throws Exception {
        if(head == null)
            throw new Exception("Error: Empty list");

        if(head.next == null)
            head = null;

        Node it = head;
        while(it.next.next != null) {
            it = it.next;
        }
        it.next = null;
    }

    public Node find(int data) {
        Node it = head;
        while(it != null && it.data != data) {
            it = it.next;
        }
        return it;
    }

    public void erase(int data) throws Exception {
        if(head == null)
            throw new Exception("Error: Empty list");
        Node it = head;

        if(it.data == data) {
            head = head.next;
        }
        else {
            while(it.next != null) {
                if(it.next.data == data) {
                    it.next = it.next.next;
                    break;
                }
                it = it.next;
            }
        }
    }

    public Boolean isEmpty() {
        if(head == null)
            return Boolean.TRUE;
        else
            return Boolean.FALSE;
    }

    public void addBefore(Node n, int data) throws Exception {
        if(head == null)
            throw new Exception("Error: Empty list");

        Node it = head;
        Node n1 = new Node(data);
        if(it.data == n.data) {
            n1.next = head;
            head = n1;
        }
        else {
            while(it.next != null) {
                if(it.next.data == n.data) {
                    n1.next = it.next;
                    it.next = n1;
                    break;
                }
                it = it.next;
            }
        }
    }

    public void addAfter(Node n, int data) {
        Node n1 = new Node(data);
        n1.next = n.next;
        n.next = n1;
    }

    public int size() {
        int size = 0;

        Node n = head;
        while(n != null) {
            size++;
            n = n.next;
        }
        return size;
    }

    public Node get(int index) throws Exception {
        if(head == null)
            throw new Exception("Error: Empty list");

        int size = 0;
        Node n = head;
        while(n != null) {
            size++;
            if(size == index)
                return n;
            n = n.next;
        }
        return null;
    }

    public void add(int index, int data) throws Exception {
        if(head == null)
            throw new Exception("Error: Empty list");

        Node n1 = new Node(data);
        Node n = head;
        int size = 0;

        while(n != null) {
            size++;
            if(size + 1 == index) {
                n1.next = n.next;
                n.next = n1;
            }
            n = n.next;
        }
    }

    public void remove(int index) throws Exception {
        if(head == null)
            throw new Exception("Error: Empty list");

        Node n = head;
        int size = 0;

        while(n != null) {
            size++;
            if(size + 1 == index) {
                n.next = n.next.next;
            }
            n = n.next;
        }
    }

    public void reverseList() throws Exception {
        Node currNode = head;
        Node prevNode = null;
        Node nextNode = null;

        while(currNode != null) {
            nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
        }
        head = prevNode;
    }

    public Node valueNthFromEnd(int nth) throws Exception {
        if(head == null)
            throw new Exception("Error: Empty list");

        Node result = null;
        int pos = 0;
        Node n = head;
        while(n.next != null) {
            pos++;
            if(pos == nth) {
                result = head;
            }
            n = n.next;
            if(result != null) {
                result = result.next;
            }
        }
        return result;
    }

    //Time - O(n)
    //Space - O(1)
    public Node valueNthFromEndGabe(int k) throws Exception{
        Node p1 = head;
        Node p2 = head;

        for(int i = 0; i < k; i++) {
            if(p1 == null)
                return null;
            p1 = p1.next;
        }

        while(p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }

    //Time - O(n^2)
    //Space - O(1)
    public void removeDups() throws Exception {
        if(head == null)
            throw new Exception("Error: Empty list");

        if(head.next == null) {
            return;
        }

        Node n = head;
        while(n != null) {
            Node j = n;
            while(j.next != null) {
                if(j.next.data == n.data) {
                    j.next = j.next.next;
                }
                else {
                    j = j.next;
                }
            }
            n= n.next;
        }
    }

    //Time and Space - O(n)
    public void removeDupsEfficient() throws Exception {
        HashSet<Integer> set = new HashSet<>();
        Node previous = null;
        Node n = head;

        while(n!= null) {
            if(set.contains(n.data)){
                previous.next = n.next;
            }
            else {
                set.add(n.data);
                previous = n;
            }
            n = n.next;
        }
    }

    public void deleteFromMiddle() throws Exception {
        if(head == null)
            throw new Exception("Error: Empty list");

        if(head.next == null) {
            return;
        }

        int size = 1;
        Node n = head;
        Node m = head;
        Node p = head;

        while(n!=null){
            size++;
            if(size % 2 == 1) {
                p = m;
                m = m.next;
            }
            n = n.next;
        }

        if(p != null && p.next != null) {
            p.next = p.next.next;
        }
    }

    //Time and Space O(1)
    public boolean deleteNodeGabe(Node n) {
        if(n == null || n.next == null) {
            return false;
        }

        Node next = n.next;
        n.data = next.data;
        n.next = next.next;
        return true;
    }

    public Node partition(Node node, int x) {
        Node beforeStart = null;
        Node beforeEnd = null;
        Node afterStart = null;
        Node afterEnd = null;

        while(node != null) {
            Node next = node.next;
            node.next = null;

            if(node.data < x) {
                //Insert node into end of before list
                if(beforeStart == null) {
                    beforeStart = node;
                    beforeEnd = beforeStart;
                }
                else {
                    beforeEnd.next = node;
                    beforeEnd = node;
                }
            }
            else {
                //Insert node into end of after list
                if(afterStart == null) {
                    afterStart = node;
                    afterEnd = afterStart;
                }
                else {
                    afterEnd.next = node;
                    afterEnd = node;
                }
            }
            node = next;
        }

        if(beforeStart == null) {
            return afterStart;
        }

        //Merge list
        beforeEnd.next = afterStart;
        return beforeStart;
    }

    public Node partitionOptimal(Node node, int x) {
        Node head = node;
        Node tail = node;

        while(node != null) {
            Node next = node.next;
            if(node.data < x) {
                //Insert node at head
                node.next = head;
                head = node;
            }
            else {
                //Insert node at tail
                tail.next = node;
                tail = node;
            }
            node = next;
        }
        tail.next = null;

        return head;
    }


    public void printList(Node n) {
        Node it = n;
        StringBuffer buf = new StringBuffer();

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

    public static void main(String[] args) throws Exception {
        System.out.println("New List");
        LinkedList l = new LinkedList(1);
        l.printList(l.topFront());

        System.out.println("pushFront 0");
        l.pushFront(0);
        Node front = l.topFront();
        if(front != null && front.data != 0)
            System.out.println("pushFront or topFront failed");
        l.printList(l.topFront());

        System.out.println("popFront");
        l.popFront();
        front = l.topFront();
        if(front != null && front.data == 0)
            System.out.println("popFront failed");
        l.printList(l.topFront());

        System.out.println("pushBack 2");
        l.pushBack(2);
        Node tail = l.topBack();
        if(tail != null && tail.data != 2)
            System.out.println("pushBack failed");
        l.printList(l.topFront());

        System.out.println("popBack");
        l.popBack();
        tail = l.topBack();
        if(tail != null && tail.data == 2)
            System.out.println("popBack failed");
        l.printList(l.topFront());

        System.out.println("find");
        l.pushBack(2);
        Node found = l.find(2);
        if(found == null)
            System.out.println("find failed");

        System.out.println("erase 0");
        l.pushFront(0);
        l.printList(l.topFront());
        l.erase(0);
        front = l.topFront();
        if(front != null && front.data == 0)
            System.out.println("erase failed");
        l.printList(l.topFront());

        System.out.println("erase 5");
        l.pushBack(5);
        l.printList(l.topFront());
        l.erase(5);
        tail = l.topBack();
        if(tail != null && tail.data == 5)
            System.out.println("erase failed");
        l.printList(l.topFront());

        System.out.println("isEmpty");
        Boolean isEmpty = l.isEmpty();
        if(isEmpty)
            System.out.println("isEmpty failed");

        System.out.println("addBefore 3 before 2");
        Node n = l.find(2);
        l.addBefore(n, 3);
        Node n1 = l.find(3);
        if(n1 == null || n1.next != n)
            System.out.println("addBefore failed");
        l.printList(l.topFront());

        System.out.println("addAfter 4 after tail");
        tail = l.topBack();
        l.addAfter(tail, 4);
        n = l.find(4);
        if(n == null || l.topBack().data != 4)
            System.out.println("addAfter failed");
        l.printList(l.topFront());

        System.out.println("size");
        int size = l.size();
        if(size != 4)
            System.out.println("size failed");

        System.out.println("get");
        Node i = l.get(3);
        if(i == null || i.data != 2)
            System.out.println("get failed");

        System.out.println("add index");
        l.add(2, 7);
        Node idx2 = l.get(2);
        if(idx2 == null || idx2.data != 7)
            System.out.println("add index failed");
        l.printList(l.topFront());

        System.out.println("remove index");
        l.remove(2);
        idx2 = l.get(2);
        if(idx2 == null || idx2.data != 3)
            System.out.println("remove index failed");
        l.printList(l.topFront());

        System.out.println("reverse");
        l.reverseList();
        l.printList(l.topFront());

        System.out.println("nth from last - mandeep");
        Node nth = l.valueNthFromEnd(3);
        if(nth == null || nth.data != 2)
            System.out.println("nth from last failed");

        System.out.println("nth from last - gabe");
        nth = l.valueNthFromEndGabe(3);
        if(nth == null || nth.data != 2)
            System.out.println("nth from last failed");

        System.out.println("Remove dups");
        l.add(2, 1);
        l.add(3, 4);
        l.add(4, 4);
        l.printList(l.topFront());
        l.removeDups();
        l.printList(l.topFront());

        System.out.println("Remove dups efficient");
        l.add(2, 1);
        l.add(3, 4);
        l.add(4, 4);
        l.printList(l.topFront());
        l.removeDupsEfficient();
        l.printList(l.topFront());

        System.out.println("Delete from middle");
        l.add(2, 7);
        l.add(3, 6);
        l.add(4, 9);
        l.add(5, 10);
        l.printList(l.topFront());
        l.deleteFromMiddle();
        l.printList(l.topFront());

        System.out.println("Delete node");
        l.printList(l.topFront());
        l.deleteNodeGabe(l.find(9));
        l.printList(l.topFront());

        System.out.println("Partition");
        LinkedList l1 = new LinkedList(3);
        l1.pushBack(5);
        l1.pushBack(8);
        l1.pushBack(5);
        l1.pushBack(10);
        l1.pushBack(2);
        l1.pushBack(1);
        l1.printList(l1.topFront());
        l1.partition(l1.topFront(), 5);
        l1.printList(l1.topFront());

        System.out.println("Partition Optimal");
        LinkedList l2 = new LinkedList(3);
        l2.pushBack(5);
        l2.pushBack(8);
        l2.pushBack(5);
        l2.pushBack(10);
        l2.pushBack(2);
        l2.pushBack(1);
        l2.printList(l2.topFront());
        Node p = l2.partitionOptimal(l2.topFront(), 5);
        l2.printList(p);
    }
}
