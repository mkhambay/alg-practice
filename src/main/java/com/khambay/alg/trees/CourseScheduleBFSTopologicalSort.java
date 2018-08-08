package com.khambay.alg.trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Time and Space - O(v*e) - v: vertices and e: edges
 *
 * https://en.wikipedia.org/wiki/Topological_sorting
 */
public class CourseScheduleBFSTopologicalSort {

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] edgeMatrix = new int[numCourses][numCourses]; // i -> j
        int[] incomingEdge = new int[numCourses];

        //build adj matrix
        for (int k = 0; k < prerequisites.length; k++) {
            int i = prerequisites[k][1]; //prerequisite is in column 1
            int j = prerequisites[k][0];

            if (edgeMatrix[i][j] == 0) { //makes sure no duplicates and same edge not counted twice
                incomingEdge[j]++;
            }
            edgeMatrix[i][j] = 1; //add the edge
        }

        //build queue of nodes with no edges
        Queue<Integer> nodesWithNoEdge = new LinkedList();
        for (int n = 0; n < incomingEdge.length; n++) {
            if (incomingEdge[n] == 0) { //Set of all nodes with no incoming edge
                nodesWithNoEdge.add(n);
            }
        }

        int courseCount = 0;
        //process each node with no edge
        //If nodesWithNoEdge has no such nodes (nodes with no edge to it), its not a DAG. There are cycles
        //and we should normally throw an error and not process further ex 1,0 and 0,1
        while (!nodesWithNoEdge.isEmpty()) {
            int i = nodesWithNoEdge.poll(); //remove a node i from S
            courseCount++; //course can be taken as there is no prerequisite for it

            //go through adj matrix and start removing edges from i -> j
            for (int j = 0; j < edgeMatrix[0].length; j++) {
                if (edgeMatrix[i][j] != 0) { //for each node i with an edge e from i to j do
                    incomingEdge[j]--;      //remove edge e from the graph

                    if (incomingEdge[j] == 0)  //check if no edges
                        nodesWithNoEdge.add(j); //insert j into S
                }
            }
        }
        return courseCount == numCourses;
    }


    public static void main(String[] args) {
//        int[][] prerequisites = {{1,0}};
//        System.out.println("Can take 2 courses with prerequisites = {{1,0}} ?? "
//                + canFinish(2, prerequisites));
//
//        int[][] prerequisites1 = {{1,0}, {0,1}};
//        System.out.println("Can take 2 courses with prerequisites = {{1,0}, {0,1}} ?? "
//                + canFinish(2, prerequisites1));

        int[][] prerequisites2 = {
                {11,5}, {11,7},
                {8,7}, {8,3},
                {2,11},
                {9,11}, {9,8},
                {10,11}, {10,3}
        };
        System.out.println("Can take 12 courses with prerequisites2 = " + canFinish(12, prerequisites2));
    }
}
