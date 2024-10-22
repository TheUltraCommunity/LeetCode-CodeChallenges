import java.util.*;

public class NumberOfProvinces {
  public static void main(String[] args) {
      int[][] adj = {{1, 0, 0, 1}, {0, 1, 1, 0}, {0, 1, 1, 0}, {1, 0, 0, 1} };

      int count = function(adj);
      System.out.println(count);
  }
  public static int function(int[][] adj){
    int count = 0;
    int V = adj.length;
    boolean[] visited = new boolean[V];

    for(int i = 0 ; i <V; i++){
      if(!visited[i]){
        count += 1;
        bfs(i, visited, adj);
      }
    }
    return count;
  }
  public static void bfs(int node , boolean[] visited, int[][] adj){
    Queue<Integer> q = new LinkedList<>();
    q.add(node);

    while(!q.isEmpty()){
      int polled = q.poll();

      for(int i = 0 ; i < adj.length; i++){
        if(adj[polled][i] == 1 && !visited[i]){
            q.add(i);
            visited[i] = true;
        }
      }
    }
  }
}
