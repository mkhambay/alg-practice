package com.khambay.alg.math;

import java.util.HashMap;
import java.util.Map;

/**
 * http://leetcode.com/problems/max-points-on-a-line/discuss/47113/A-java-solution-with-notes/46926
 *
 * Time - O(n^2)
 * Space - O(n)
 */
public class MaxPointsOnALine {

    public static class Point {
        int x;
        int y;

        public Point() {
            x = 0;
            y = 0;
        }

        public Point(int a, int b) {
            x = a;
            y = b;
        }
    }

    public static int maxPoints(Point[] points) {
        if(points == null) {
            return 0;
        }
        int n = points.length, result = 0;

        if(n <= 2) {
            return n;
        }

        // Map - Slope count
        // Key - x2 - x1/gcd : y2 - y1/gcd
        // Value - Number of points with that slope
        Map<String,Integer> map = new HashMap<>();

        for(int i = 0 ; i < n ; i++){
            map.clear();
            int overlap = 0, max = 0;

            for(int j = i + 1; j < n; j++){
                //slope - y2 - y1 / x2 - x1 - it does not matter which one is picked first, result is same
                //http://www.mathwarehouse.com/algebra/linear_equation/slope-of-a-line.php
                int x = points[j].x - points[i].x;
                int y = points[j].y - points[i].y;

                if (x == 0 && y == 0){
                    overlap++;
                    continue;
                }

                int gcd = gcd(x,y); // gcd will never be zero.

                x /= gcd;
                y /= gcd;

                String slope = x + ":" + y;
                map.put(slope, map.getOrDefault(slope, 0) + 1);
                max = Math.max(max, map.get(slope));
            }
            result = Math.max(result, max+overlap+1); //+1 for the origin
        }

        return result;
    }

    //Greatest Common Divisor
    // https://en.wikipedia.org/wiki/Greatest_common_divisor
    private static int gcd(int a,int b){
        if (b == 0) {
            return a;
        }
        else {
            return gcd(b,a % b);
        }
    }

    public static void main(String[] args) {
        Point[] points = {
                new Point(1,1),
                new Point(2,2),
                new Point(3,3)
            };
        System.out.println("Result = " + maxPoints(points));
        
        Point[] points1 = {
                new Point(1,1),
                new Point(3,2),
                new Point(5,3),
                new Point(4,1),
                new Point(2,3),
                new Point(1,4)
        };
        System.out.println("Result 2 = " + maxPoints(points1));
    }
}
