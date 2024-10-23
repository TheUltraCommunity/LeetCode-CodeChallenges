import java.util.List;

public class DirectedDetectCycle{
  public static void main(String args[]) {

  }
  public static boolean detech(int V, List<Integer>[] adj){
    boolean[] visited = new boolean[V];
    boolean[] path = new boolean[V];

    for (int i = 0; i < V; i++) {
      if(!visited[i]){
        if(dfs(i, adj, path, visited)){
        return true;
      }
     }
    }
    return false;
  }
  public static boolean dfs(int i, List<Integer>[] adj, boolean[] path,
    boolean[] visited){
    visited[i] = true;
    path[i] = true;

    for(int neighbor :  adj[i]){
      if(path[neighbor]){

        return true;
      }
      if(!visited[neighbor]){
        if(dfs(i, adj, path, visited)){
        return true;
        }

      }
    }
    path[i] = false;
    return false;
  }
}
