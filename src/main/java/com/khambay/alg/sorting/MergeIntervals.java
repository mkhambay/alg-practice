package com.khambay.alg.sorting;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Time - O(n log(n))
 * Space - O(n) - if no overlap
 * Sorting - O(n log(n)) and merging - O(n)
 */
public class MergeIntervals {


    public static List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() <= 1)
            return intervals;

        //sort by interval start
        intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));

        List<Interval> result = new LinkedList<>();
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;

        //Merge overlapping intervals
        for (Interval interval : intervals) {
            if (interval.start <= end) // Overlapping intervals, move the end if needed
                end = Math.max(end, interval.end);
            else {                     // Disjoint intervals, add the previous one and reset bounds
                result.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }

        // Add the last interval
        result.add(new Interval(start, end));
        return result;
    }

    public static class Interval {
        int start;
        int end;

        public Interval() {
            start = 0;
            end = 0;
        }

        public Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1,3));
        intervals.add(new Interval(2,6));
        intervals.add(new Interval(8,10));
        intervals.add(new Interval(15,18));

        List<Interval> merged = merge(intervals);
        System.out.println("Merged Intervals");

        System.out.print("[");
        for(Interval interval : merged) {
            System.out.print("[" + interval.start + "," + interval.end + "],");
        }
        System.out.print("]");
    }

}
