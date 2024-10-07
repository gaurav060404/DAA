package Graphs;
import java.util.*;

public class Prims {
    private Map<Integer, List<Edge>> adjList = new HashMap<>();

    public void addVertex(int vertex) {
        adjList.putIfAbsent(vertex, new LinkedList<>());
    }

    public void addEdge(int v1, int v2, int weight) {
        adjList.putIfAbsent(v1, new LinkedList<>());
        adjList.putIfAbsent(v2, new LinkedList<>());

        adjList.get(v1).add(new Edge(v2, weight));
        adjList.get(v2).add(new Edge(v1, weight));
    }

    // Edge class to store the destination vertex and the weight of the edge
    private class Edge {
        int vertex;
        int weight;

        Edge(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }

    // Prim's algorithm to find the Minimum Spanning Tree (MST)
    public void primsMST(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        Set<Integer> visited = new HashSet<>();
        List<Edge> mst = new ArrayList<>();

        // Start with the given start vertex
        visited.add(start);
        pq.addAll(adjList.get(start));

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();

            if (visited.contains(edge.vertex)) {
                continue;
            }

            visited.add(edge.vertex);
            mst.add(edge);

            for (Edge nextEdge : adjList.get(edge.vertex)) {
                if (!visited.contains(nextEdge.vertex)) {
                    pq.add(nextEdge);
                }
            }
        }

        // Print the MST
        for (Edge edge : mst) {
            System.out.println("Edge: " + edge.vertex + " - Weight: " + edge.weight);
        }
    }

    public static void main(String[] args) {
        Prims graph = new Prims();

        // Adding vertices
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);

        // Adding edges with weights
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 4);
        graph.addEdge(2, 3, 2);
        graph.addEdge(2, 4, 5);
        graph.addEdge(3, 4, 3);

        // Running Prim's algorithm from vertex 1
        graph.primsMST(1);
    }
}
