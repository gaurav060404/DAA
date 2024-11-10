package Graphs;

import java.util.*;

public class Graph {
    private static Map<Integer, List<Integer>> adjList;

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

    // bfs
    public static void bfs(int start) {
        Set<Integer> visisted = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();

        visisted.add(start);
        q.add(start);

        while (!q.isEmpty()) {
            int vertex = q.poll();
            System.out.print(start + " ");
            for (int neighbor : adjList.get(vertex)) {
                if (!visisted.contains(neighbor)) {
                    visisted.add(neighbor);
                    q.add(neighbor);
                }
            }
        }
    }

    // Topological Sort
    public static List<Integer> topologicalSort() {
        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        for (Integer vertex : adjList.keySet()) {
            if (!visited.contains(vertex)) {
                topologicalSortUtil(vertex, visited, stack);
            }
        }
        List<Integer> sortedList = new ArrayList<>();
        while (!stack.isEmpty()) {
            sortedList.add(stack.pop());
        }
        return sortedList;
    }

    private static void topologicalSortUtil(int vertex, Set<Integer> visited, Stack<Integer> stack) {
        visited.add(vertex);
        for (Integer neighbor : adjList.get(vertex)) {
            if (!visited.contains(neighbor)) {
                topologicalSortUtil(neighbor, visited, stack);
            }
        }
        stack.push(vertex);
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

        System.out.println("Topological Sort : " + topologicalSort());
    }
}