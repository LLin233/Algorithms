package graph;

import java.util.*;

/**
 * Created by Le on 2016/2/2.
 */


/**
 * There are 3 properties to check if a graph is a tree:
 * <p>
 * (1) The number of edges in the graph is exactly one less than the number of vertices |E| = |V| - 1
 * (2) There are no cycles
 * (3) The graph is connected
 * <p>
 * # given a graph and a starting vertex, check if the graph is a tree
 * def checkTree(G, v):
 * # |E| = |V| - 1
 * if edges.size != vertices.size - 1:
 * return false;
 * <p>
 * for v in vertices:
 * visited[v] = false;
 * <p>
 * hasCycle = explore_and_check_cycles(G, v);
 * <p>
 * # a tree is acyclic
 * if hasCycle:
 * return false;
 * <p>
 * for v in vertices:
 * if not visited[v]: # the graph isn't connected
 * return false;
 * <p>
 * # otherwise passes all properties for a tree
 * return true;
 * <p>
 * # given a Graph and a vertex, explore all reachable vertices from the vertex
 * # and returns true if there are any cycles
 * def explore_and_check_cycles(G, v):
 * visited[v] = true;
 * for (v, u) in edges:
 * if not visited[u]:
 * return explore_and_check_cyles(G, u)
 * else: # a backedge between two vertices indicates a cycle
 * return true
 * return false
 */
public class DirectedGraphTree {

    private static int VISITED = 2;
    private static int VISITTING = 1;
    private static int NOT_VISITED = 0;

    public boolean validTree(List<Integer> vertexs, int n, int[][] edges) {

        if (n <= 0 || edges == null || edges.length == 0) {
            return false;
        }
        if (n - edges.length != 1) {
            return false;
        }
        HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();
        HashMap<Integer, Integer> visited = new HashMap<>();
        for (Integer vertex : vertexs) {
            visited.put(vertex, NOT_VISITED);
        }
        for (int i = 0; i < edges.length; i++) {
            int from = edges[i][1];
            int to = edges[i][0];
            if (!graph.containsKey(from)) {
                HashSet<Integer> set = new HashSet<>();
                graph.put(from, set);
            }
            HashSet<Integer> set = graph.get(from);
            set.add(to);
            graph.put(from, set);
        }

        for (int i = 1; i <= n; i++) {
            if (visited.get(i) == NOT_VISITED ) {
                if (hasCycle(i, visited, graph)) {
                    return false;
                } else {
                    continue;
                }
            }
        }
        for (Integer vertex : visited.keySet()) {
            if (visited.get(vertex) == NOT_VISITED) {
                return false;
            }
        }
        return true;
    }
    private boolean hasCycle(int v, HashMap<Integer, Integer> visited, HashMap<Integer, HashSet<Integer>> graph) {
        if (graph.containsKey(v)) {
            visited.put(v, VISITTING);
            HashSet<Integer> adjacencyList = graph.get(v);
            for (int to : adjacencyList) {
                if (visited.get(to) == VISITTING) {return true;}
                if (visited.get(to) == NOT_VISITED && hasCycle(to, visited, graph)) {return true;}
            }
        }
        visited.put(v, VISITED); //visiting finished
        return false;
    }

    public static void main(String[] args) {
        Integer[] array = {1, 2, 3};
        List<Integer> vertexs = new ArrayList<Integer>(Arrays.asList(array));

        Scanner scanner = new Scanner(System.in);

        int numVertices = scanner.nextInt();
        int numEdges = scanner.nextInt();
        int[][] edges = new int[numEdges][2];

        for (int i = 0; i < numEdges; i++) {
            edges[i][0] = scanner.nextInt();
            edges[i][1] = scanner.nextInt();
        }
        boolean result = new DirectedGraphTree().validTree(vertexs, numVertices, edges);

        System.out.println(result);

        scanner.close();
    }
}
