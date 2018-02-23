package com.khambay.alg.stack;

public class FixedMultiStack {
    int[] values;
    int[] sizes;
    int numberOfStacks = 3;
    int stackCapacity;

    public FixedMultiStack(int stackSize) {
        stackCapacity = stackSize;
        values = new int[stackSize * numberOfStacks];
        sizes = new int[numberOfStacks];
    }

    public void push(int stackNumber, int value) throws Exception {
        if(isFull(stackNumber)) {
            throw new Exception("Stack " + stackNumber + " Full");
        }
        sizes[stackNumber]++;
        values[indexOfTop(stackNumber)] = value;

    }


    public int pop(int stackNumber) throws Exception {
        if(isEmpty(stackNumber)) {
            throw new Exception("Stack " + stackNumber + " Is Empty");
        }
        int topIndex = indexOfTop(stackNumber);
        int value = values[topIndex];
        values[topIndex] = 0;
        sizes[stackNumber]--;
        return value;
    }


    public int peek(int stackNumber) throws Exception {
        if(isEmpty(stackNumber)) {
            throw new Exception("Stack " + stackNumber + " Is Empty");
        }
        return values[indexOfTop(stackNumber)];
    }

    public boolean isFull(int stackNumber) {
        return sizes[stackNumber] == stackCapacity;
    }

    public boolean isEmpty(int stackNumber) {
        return sizes[stackNumber] == 0;
    }

    public int[] getValues() {
        return values;
    }

    public void printStack() {
        int[] values = getValues();
        System.out.print("values=[");
        for(int idx = 0; idx < values.length-1; idx++) {
            System.out.print(+ values[idx] + ", ");
        }
        System.out.println(values[values.length-1] + "]");
    }

    private int indexOfTop(int stackNumber) {
        int offset = stackNumber * stackCapacity;
        int size = sizes[stackNumber];
        return offset + size - 1;
    }

    public static void main(String[] args) throws Exception {
        FixedMultiStack fixedMultiStack = new FixedMultiStack(3);
        fixedMultiStack.push(0,1);
        fixedMultiStack.push(0,2);
        fixedMultiStack.push(0,3);
        fixedMultiStack.push(1,4);
        fixedMultiStack.push(1,5);
        fixedMultiStack.push(1,6);
        fixedMultiStack.push(2,7);
        fixedMultiStack.push(2,8);
        fixedMultiStack.push(2,9);
        fixedMultiStack.printStack();

        System.out.println("Pop from all stacks");
        int popItemStack1 = fixedMultiStack.pop(0);
        int popItemStack2 = fixedMultiStack.pop(1);
        int popItemStack3 = fixedMultiStack.pop(2);
        fixedMultiStack.printStack();

        System.out.println("Peek from all stacks");
        System.out.println("Peek Stack 0 =" + fixedMultiStack.pop(0));
        System.out.println("Peek Stack 1 =" + fixedMultiStack.pop(1));
        System.out.println("Peek Stack 2 =" + fixedMultiStack.pop(2));
    }
}
