package Graphs;
import java.util.*;

public class Graph {
    private Map<Integer, List<Integer>> adjList;

    public Graph() {
        adjList = new HashMap<>();
    }

    public void addVertex(int vertex) {
        adjList.putIfAbsent(vertex, new LinkedList<>());
    }

    public void addEdge(int v1, int v2) {
        adjList.putIfAbsent(v1, new LinkedList<>());
        adjList.putIfAbsent(v2, new LinkedList<>());

        adjList.get(v1).add(v2);
        adjList.get(v2).add(v1);
    }

    // DFS method
    public void dfs(int start) {
        Set<Integer> visited = new HashSet<>();
        dfsHelper(start, visited);
    }

    // Recursive DFS helper method
    private void dfsHelper(int vertex, Set<Integer> visited) {
        // Mark the current node as visited and print it
        visited.add(vertex);
        System.out.print(vertex + " ");

        // Recur for all the vertices adjacent to this vertex
        for (int neighbor : adjList.get(vertex)) {
            if (!visited.contains(neighbor)) {
                dfsHelper(neighbor, visited);
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph();

        // Adding vertices
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);

        // Adding edges
        graph.addEdge(1, 2);
        graph.addEdge(2, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        // Perform DFS starting from vertex 1
        System.out.println("Depth-First Search starting from vertex 1:");
        graph.dfs(1);
    }
}