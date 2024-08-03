package graphs.java;

public class numberOfProvinces {
    public int findCircleNum(int[][] isConnected) {
        int V = isConnected.length;
        boolean[] visited = new boolean[V];
        int count = 0;

        for(int i = 0; i < V; i++){
            if(!visited[i]){
                dfs(isConnected, visited, i);
                count++;
            }
        }
        
        return count;
    }

    private void dfs(int[][] isConnected, boolean[] visited, int i) {
        visited[i] = true;
        for(int j = 0; j < isConnected.length; j++){
            if(isConnected[i][j] == 1 && !visited[j]){
                dfs(isConnected, visited, j);
            }
        }
    }
}
