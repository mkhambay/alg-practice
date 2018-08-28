package com.khambay.alg.design;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Implement an iterator to flatten a 2d vector.
 *
 * https://leetcode.com/problems/flatten-2d-vector/description/
 */
public class Vector2D implements Iterator<Integer> {
    private Iterator<List<Integer>> i;
    private Iterator<Integer> j;

    public Vector2D(List<List<Integer>> vec2d) {
        i = vec2d.iterator();
    }

    @Override
    public Integer next() {
        return j.next();
    }

    @Override
    public boolean hasNext() {
        while((j == null || !j.hasNext()) && i.hasNext()) {
            j = i.next().iterator();
        }
        return j != null && j.hasNext();
    }

    public static void main(String[] args) {
        List<Integer> valList = new ArrayList<>();
        valList.add(1);
        valList.add(2);

        List<Integer> valList1 = new ArrayList<>();
        valList1.add(3);

        List<Integer> valList2 = new ArrayList<>();
        valList2.add(4);
        valList2.add(5);
        valList2.add(6);

        List<List<Integer>> vec2d = new ArrayList<>();
        vec2d.add(valList);
        vec2d.add(valList1);
        vec2d.add(valList2);

        Vector2D i = new Vector2D(vec2d);
        System.out.print("[");
        while (i.hasNext()) {
            System.out.print(i.next() + ",");
        }
        System.out.println("]");
    }
}
