import java.util.*;

class ConnectedComponents{
  public static void main(String args[]){
    int V= 4;
    int E = 2;
    int edges[][] = {{0, 1}, {1, 2}};

    // to calculate connected components
    // algorithm is simple
    // construct the graph
    // do a bfs from 0 to V-1 and count at every bfs
    int[][] adj = constructGraph(V, E, edges);
    boolean visited[] = new boolean[V];
    int count= 0;

    for(int i=0; i < V; i++){
      if(!visited[i]){
        count++;
        bfs(adj, visited, i);
      }
    }
    System.out.println(count);
  }
  public static int[][] constructGraph(int V, int E, int[][] edges){
    int[][] adj = new int[V+1][V+1];

    for(int i = 0 ; i < edges.length; i++){
      int u  = edges[i][0];
      int v  = edges[i][1];

      adj[u][v] = 1;
      adj[v][u] = 1;
    }
    return adj;
  }
  public static void bfs(int[][] adj, boolean[] visited, int node){
    Queue<Integer> q = new LinkedList<Integer>();
    q.add(node);
    visited[node] = true;
    while(!q.isEmpty()){
        Integer polled = q.poll();
        for(int i = 0; i< adj.length; i++){
          if(adj[i][polled] == 1 && !visited[i]){
            visited[i]=true;
            q.add(i);
          }
        }
    }
  }
}
