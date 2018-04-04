package com.khambay.alg.trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Time and Space - O(v*e) - v: vertices and e: edges
 */
public class CourseScheduleBFSTopologicalSortII {

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] order = new int[numCourses];
        int[][] edgeMatrix = new int[numCourses][numCourses]; // i -> j
        int[] incomingEdge = new int[numCourses];

        //build adj matrix
        for (int k = 0; k < prerequisites.length; k++) {
            int i = prerequisites[k][1];
            int j = prerequisites[k][0];

            if (edgeMatrix[i][j] == 0) {
                incomingEdge[j]++;
            }
            edgeMatrix[i][j] = 1;
        }

        //build queue of nodes with no edges
        Queue<Integer> nodesWithNoEdge = new LinkedList();
        for (int n = 0; n < incomingEdge.length; n++) {
            if (incomingEdge[n] == 0) { //Set of all nodes with no incoming edge
                nodesWithNoEdge.add(n);
            }
        }

        int visited = 0;
        //process each node with no edge
        while (!nodesWithNoEdge.isEmpty()) {
            int i = nodesWithNoEdge.poll(); //remove a node i from S
            order[visited++] = i;

            //go through adj matrix and start removing edges from i -> j
            for (int j = 0; j < edgeMatrix[0].length; j++) {
                if (edgeMatrix[i][j] != 0) { //for each node i with an edge e from i to j do
                    incomingEdge[j]--;      //remove edge e from the graph

                    if (incomingEdge[j] == 0)  //check if no edges
                        nodesWithNoEdge.add(j); //insert j into S
                }
            }
        }
        return visited == numCourses ? order : new int[0];
    }

    public static void printArray(int[] arr) {
        System.out.print("[");
        for(int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i] + ",");
        }
        System.out.println(arr[arr.length - 1] + "]");
    }

    public static void main(String[] args) {
        int[][] prerequisites = {{1,0}};
        System.out.println("Can take 2 courses with prerequisites = {{1,0}} ?? ");
        printArray(findOrder(2, prerequisites));

        int[][] prerequisites1 = {{1,0}, {2,1}, {3,1}, {3,2}};
        System.out.println("Can take 2 courses with prerequisites = {{1,0}, {2,1}, {3,1}, {3,2}}");
        printArray(findOrder(4, prerequisites1));

        int[][] prerequisites2 = {
                {11,5}, {11,7},
                {8,7}, {8,3},
                {2,11},
                {9,11}, {9,8},
                {10,11}, {10,3}
        };
        System.out.println("Can take 12 courses with prerequisites2 = ");
        printArray(findOrder(12, prerequisites2));
    }
}
