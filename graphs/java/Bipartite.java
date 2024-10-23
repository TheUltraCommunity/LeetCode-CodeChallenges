import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Bipartite {
  public static void main(String args[]) {

  }
  public static boolean check(int V, List<Integer>[] adj){
    int[] colors = new int[V+1];
    Arrays.fill(colors, -1);

    for (int i = 0; i <= V; i++) {
       if(colors[i] == -1){
         if(bfs(colors, adj, i)){
           return true;
         }
       }
    }
    return false;
  }
  public static boolean bfs(int[] colors, List<Integer>[] adj, int node){
    Queue<Integer> q = new LinkedList<>();
    q.add(node);
    colors[node] = 0;
    while (!q.isEmpty()) {
      int polled = q.poll();

      for(int neighbor : adj[polled]){
        if(colors[neighbor] == -1){
          colors[neighbor] = 1 - colors[polled];
          q.offer(neighbor);
        }else if (colors[node] == colors[neighbor]){
          return false;
        }
      }
    }
    return true;
  }
  public static boolean dfs(int[] colors, List<Integer> adj, int node){
    colors[node] = true;

    for(int neighbor : adj[node]){
      if(colors[neighbor] == -1){
        colors[neighbor] = 1 - colors[node];
        dfs(colors, adj, neighbor);
      }else if(colors[node]==colors[neighbor]){
        return false;
      }
    }
    return true;
  }
}
