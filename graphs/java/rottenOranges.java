package graphs.java;

import java.util.*;

class Tuple{
    int first, second, time;

    public Tuple(int first, int second, int time){
        this.first = first;
        this.second = second;
        this.time = time;

    }
}
class rottenOranges {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] visited = new int[n][m];

        Queue<Tuple> q = new LinkedList<Tuple>();

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == 2){
                    q.add(new Tuple(i , j, 0));
                    visited[i][j] = 2;
                }else {
                    visited[i][j]= 0;
                }
            }
        }   

        int time = 0;
        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, 1, 0, -1};

        while(!q.isEmpty()){
            Tuple node = q.poll();
            int first = node.first;
            int second = node.second;
            int t = node.time; 
            time = t;

            for(int k = 0 ; k < 4 ; k++){
                int nrow = delrow[k] + first;
                int ncol = delcol[k] + second;

                if(nrow >= 0 && 
                nrow < n && 
                ncol >= 0 &&
                ncol < m && 
                grid[nrow][ncol] == 1 &&
                visited[nrow][ncol] !=  2){
                    q.add(new Tuple(nrow, ncol, time + 1));
                    visited[nrow][ncol] = 2;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] != 2 && grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return time;
    }
}
