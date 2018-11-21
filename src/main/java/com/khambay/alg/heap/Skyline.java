package com.khambay.alg.heap;

import java.util.*;

/**
 * https://youtu.be/GSBLe8cKu0s
 * Time - O(nlogn) - but PriorityQueue remove takes O(n). For O(nlogn) need to use TreeSet.
 */
public class Skyline {
    public static List<int[]> getSkyline(int[][] buildings) {
        List<int[]> result = new ArrayList<>();
        List<int[]> heights = new ArrayList<>();
        int lr = 0;
        int h = 1;

        for(int[] b : buildings) {
            heights.add(new int[]{b[0], -b[2]}); //l - 0 added with -height
            heights.add(new int[]{b[1], b[2]});  //r - 1 added with height
        }
        Collections.sort(heights, (a, b) -> {
            if(a[lr] != b[lr]) //l and r are different, order on them
                return a[lr] - b[lr];
            return a[h] - b[h]; //both l and r are same, order on height
        });

        Queue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a)); //sort height descending
        pq.offer(0);

        int prevMax = 0;
        for(int[] height : heights) {
            if(height[h] < 0) {
                pq.offer(-height[h]); //l - begin - we add to queue
            } else {
                pq.remove(height[h]); //r - end - we remove from queue - takes O(n)
            }

            int max = pq.peek();
            if(prevMax != max) { //if current priority queue max value not same as prev, its a new result
                result.add(new int[]{height[lr], max});
                prevMax = max; //save the current max
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] buildings = {{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}};
        List<int[]> result = getSkyline(buildings);

        for(int[] a : result) {
            System.out.print("[");
            for(int num : a) {
                System.out.print(num + ",");
            }
            System.out.println("]");
        }
    }
}
