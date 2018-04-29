package com.khambay.alg.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * LinkedList Deep Copy
 * Time and Space - O(n)
 */
public class CopyListWithRandomPointer {

    static class RandomListNode {
        int label;
        RandomListNode next, random;

        RandomListNode(int x) {
            this.label = x;
        }
    }

    public static RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }

        Map<RandomListNode, RandomListNode> map = new HashMap<>();

        // loop 1. copy all the nodes
        RandomListNode node = head;
        while (node != null) {
            map.put(node, new RandomListNode(node.label));
            node = node.next;
        }

        // loop 2. assign next and random pointers
        node = head;
        while (node != null) {
            map.get(node).next = map.get(node.next);
            map.get(node).random = map.get(node.random);
            node = node.next;
        }

        return map.get(head);
    }

    public static void main(String[] args) {
        RandomListNode head = new RandomListNode(0);
        RandomListNode one = new RandomListNode(1);
        RandomListNode two = new RandomListNode(2);
        head.next = one;
        head.random = two;
        one.next = two;
        one.random = null;
        two.next = null;
        two.random = null;

        RandomListNode copy = copyRandomList(head);
    }
}
