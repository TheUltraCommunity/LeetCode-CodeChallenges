import java.util.*;

class Traversals {
    public static void main(String[] args) {
        int V = 5;
        int[][] edges = { { 0, 2 }, { 0, 3 }, { 0, 1 }, { 2, 4 } };

        // Construct adjacency list
        List<List<Integer>> adj = construct(V, edges);
        boolean[] visited = new boolean[V];

        System.out.println("BFS Traversal:");
        // Perform BFS on all components
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                bfs(visited, adj, i);
            }
        }

        // Reset visited array for DFS
        Arrays.fill(visited, false);
        System.out.println("\nDFS Traversal:");
        // Perform DFS on all components
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(visited, adj, i);
            }
        }
    }

    // Function to construct adjacency list from edge list
    public static List<List<Integer>> construct(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();

        // Initialize adjacency list
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Populate adjacency list
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            adj.get(u).add(v); // Add edge u -> v
            adj.get(v).add(u); // Add edge v -> u since it's undirected
        }
        return adj;
    }

    // BFS traversal
    public static void bfs(boolean[] visited, List<List<Integer>> adj, int node) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        visited[node] = true;

        // While there are still nodes to process
        while (!q.isEmpty()) {
            int polled = q.poll();
            System.out.print(polled + " -> "); // Print current node

            // Traverse all neighbors
            for (int neighbor : adj.get(polled)) {
                if (!visited[neighbor]) {
                    q.add(neighbor);
                    visited[neighbor] = true;
                }
            }
        }
        System.out.println("null"); // End of component
    }

    // DFS traversal
    public static void dfs(boolean[] visited, List<List<Integer>> adj, int node) {
        visited[node] = true;
        System.out.print(node + " -> "); // Print current node

        // Visit all neighbors
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(visited, adj, neighbor);
            }
        }
    }
}

