package com.khambay.alg.design;

import java.util.Iterator;
import java.util.List;

public class NestedIterator implements Iterator<Integer> {

    public class Stack<T> {

        class StackNode {
            T val;
            StackNode next;

            public StackNode(T val) {
                this.val = val;
            }
        }

        StackNode head;

        public void push(T val) {
            StackNode s = new StackNode(val);
            s.next = head;
            head = s;
        }

        public T pop() {
            if(head != null) {
                StackNode node = head;
                head = head.next;
                return node.val;
            }
            return null;
        }

        public T peek() {
            if(head == null) {
                return null;
            }
            return head.val;
        }

        public boolean isEmpty() {
            return head == null;
        }
    }

    Stack<NestedInteger> stack = new Stack<>();

    public NestedIterator(List<NestedInteger> nestedList) {
        if(nestedList == null) {
            return;
        }

        //Add to stack in reverse order
        for(int i = nestedList.size()-1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        if(!stack.isEmpty()) {
            return stack.pop().getInteger();
        }
        else {
            return null;
        }
    }

    @Override
    public boolean hasNext() {
        while(!stack.isEmpty()) {//keep processing till we get an Integer
            NestedInteger head = stack.peek();
            if(head.isInteger()) {
                return true;
            }
            else {//its a List, expand it
                //Remove the list from stack, expand and put it back on stack
                List<NestedInteger> nestedIntegerList = stack.pop().getList();

                //Add to stack reverse order
                for(int i = nestedIntegerList.size()-1; i >= 0; i--) {
                    stack.push(nestedIntegerList.get(i));
                }
            }
        }
        return false;
    }
}
