import java.util.LinkedList;
import java.util.Queue;
import java.util.zip.CRC32;

class Pair{
  int parent;
  int x;
  public Pair(int parent, int x){
    this.parent = parent;
    this.x = x;
  }
}
public class DetectCycle{
  public static void main(String args[]) {

  }
  public static boolean isCycle(int V, List<Integer>[] adj){

    boolean[] visited = new boolean[V];
    for (int i = 0; i < V; i++) {
      if(!visited[i]){
        if(bfs(i, adj, visited)){
          return true;
        }
      }
    }
    return false;
  }
  public static boolean bfs(int node, List<Integer>[] adj, boolean[] visited){
    Queue<Pair> q = new LinkedList<>();
    q.add(new Pair(node, -1));
    visited[node] = true;
    while(!q.isEmpty()){
      Pair curr = q.poll();
      int parent = curr.parent;
      int x = curr.x;

      for(Integer neighbor: adj[node]){
        if(!visited[neighbor]){
          visited[neighbor] = true;
          q.offer(new Pair(neighbor ,node));
        }else if( parent != neighbor){
          return true;
        }
      }
    }
    return false;
  }
}
