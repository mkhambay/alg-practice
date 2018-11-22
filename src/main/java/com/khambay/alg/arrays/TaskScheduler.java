package com.khambay.alg.arrays;

import java.util.Arrays;

/**
 * Time - O(nlogn) - sort
 */
public class TaskScheduler {

    public static int leastInterval(char[] tasks, int n) {

        int[] c = new int[26];
        for(char t : tasks){
            c[t - 'A']++;
        }

        Arrays.sort(c); //puts the max char count at the end index 25
        int i = c.length - 1;
        int maxCount = c[i];

        while(i >= 0 && c[i] == maxCount) i--; //find index where value less than max count

        return Math.max(tasks.length, (maxCount - 1) * (n + 1) + (c.length - 1 - i));
        //c[25] is the max count - 3
    }

    public static void main(String[] args) {
        char[] tasks = {'A','A','A','B','B','B'};
        System.out.println("Result = " + leastInterval(tasks, 2));
    }
}