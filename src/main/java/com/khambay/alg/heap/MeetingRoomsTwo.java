package com.khambay.alg.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Min Heap and Sorting
 *
 * Time - O(nlogn)
 * Space - O(n) for the heap
 */
public class MeetingRoomsTwo {

    public static int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0)
            return 0;

        // Sort the intervals by start time
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1.start, i2.start));

        // Use a min heap to track the minimum end time of merged intervals
        PriorityQueue<Interval> heap = new PriorityQueue<>(intervals.length, (i1, i2) -> Integer.compare(i1.end, i2.end));

        // start with the first meeting, put it to a meeting room
        heap.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            // get the meeting room that finishes earliest
            Interval interval = heap.poll();

            if (intervals[i].start >= interval.end) {
                // if the current meeting starts right after
                // there's no need for a new room, merge the interval
                interval.end = intervals[i].end;
            } else {
                // otherwise, this meeting needs a new room
                heap.add(intervals[i]);
            }
            // don't forget to put the meeting room back
            heap.add(interval);
        }
        return heap.size();
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
        Interval[] intervals = {
                new Interval(0,30),
                new Interval(5,10),
                new Interval(15,20)
        };
        System.out.println("minimum number of conference rooms required = " + minMeetingRooms(intervals));
    }
}
