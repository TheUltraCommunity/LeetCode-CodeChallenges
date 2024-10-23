import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class KahnTopo{
  public static void main(String ar[]) {


  }
  public static void topoSort(int V, List<Integer>[] adj){
    boolean[] visited = new boolean[V+1];
    Stack<Integer> stack = new Stack<>();

    for(int i = 0 ; i < V; i++){
      if(!visited[i]){
        dfs(i, visitedi, stack, adj);
      }
    }
    while(!stack.isEmpty()){
      System.out.println(stack.pop());
    }
  }
  public static void dfs(int node, boolean[] visited, Stack<Integer> stack,
    List<Integer>[] adj){
    visited[node] = true;

    for(int neighbor : adj[node]){
      if(!visited[neighbor]){
        dfs(node, visited, stack, adj);
      }
    }
    stack.add(neighbor);

  }

  public int[] topoSort(int V, List<Integer> adj[]) {
        int[] ans = new int[V];
        int[] inDegree = new int[V];

        for (int i = 0; i < V; i++) {
            for (int it : adj[i]) inDegree[it]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) q.add(i);
        }

        int index = 0; // Index to store elements in ans array

        while (!q.isEmpty()) {
            int node = q.poll();

            ans[index++] = node;

            for (int it : adj[node]) {
                inDegree[it]--;
                if (inDegree[it] == 0) q.add(it);
            }
        }
        return ans;
    }
 }
