package com.khambay.alg.trees;

import java.util.*;

/**
 * Graph implementation using LinkedList and Gabe's pseudocode as a guide
 * Important to keep track of visited nodes otherwise infinite loop
 */
public class Graph {

    //Adj list
    private LinkedList<Integer> vertices[];

    public Graph(int verticesSize) {
        this.vertices = new LinkedList[verticesSize];

        for (int i = 0; i < vertices.length; ++i)
            this.vertices[i] = new LinkedList();
    }

    public void addEdge(int startVertex, int endVertex) {
        vertices[startVertex].add(endVertex);
    }

    public void breadthFirstSearch(int vertex) {
        boolean visited[] = new boolean[this.vertices.length]; //keep track for visited nodes
        Queue<Integer> queue = new LinkedList<>();

        visited[vertex] = true;
        queue.add(vertex);

        while (!queue.isEmpty()) {
            vertex = queue.poll();
            visit(vertex);

            for(int num : vertices[vertex]) {
                if (!visited[num]) {
                    visited[num] = true;
                    queue.add(num);
                }
            }
        }
    }

    public boolean routeBetweenNodes(int startVertex, int endVertex) {
        boolean [] visited = new boolean[vertices.length];
        Queue<Integer> queue = new LinkedList<>();

        visited[startVertex] = true;
        queue.add(startVertex);

        while(!queue.isEmpty()) {
            startVertex = queue.poll();

            for(int num : vertices[startVertex]) {
                if(num == endVertex) {
                    return true;
                }
                if(!visited[num]) {
                    visited[num] = true;
                    queue.add(num);
                }
            }
        }
        return false;
    }

    public void depthFirstSearch(int vertix) {
        boolean visited[] = new boolean[vertices.length];
        search(vertix, visited);
    }

    private void search(int vertix, boolean visited[]) {
        visit(vertix);
        visited[vertix] = true;

        for(int num : vertices[vertix]) {
            if (!visited[num]) {
                search(num, visited);
            }
        }
    }

    public void visit(int vertix) {
        System.out.print(vertix + " ");
    }

    public static void main(String args[]) {
        Graph graph = new Graph(6);

        //0: 1,4,5
        //1: 4,3
        //2: 1
        //3: 4,2
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(0, 5);
        graph.addEdge(1, 3);
        graph.addEdge(2, 1);
        graph.addEdge(3, 2);
        graph.addEdge(1, 4);
        graph.addEdge(3, 4);

        System.out.println("BFS");
        graph.breadthFirstSearch(0);

        System.out.println("\nDFS");
        graph.depthFirstSearch(0);

        System.out.println("\n Route between nodes 0 - 3 = ");
        System.out.print(graph.routeBetweenNodes(0,3));

        System.out.println("\n Route between nodes 5 - 3 = ");
        System.out.print(graph.routeBetweenNodes(5,3));
    }
}
