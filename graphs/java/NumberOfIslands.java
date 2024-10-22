import java.util.*;

class Pair {
    int x;
    int y;
    public Pair(int i, int j) {
        this.x = i;
        this.y = j;
    }
}

public class NumberOfIslands {
    public static void main(String args[]) {
        char[][] grid = {
            { '1', '1', '1', '0', '1' },
            { '1', '0', '0', '0', '0' },
            { '1', '1', '1', '0', '1' },
            { '0', '0', '0', '1', '1' }
        };

        int count = 0;
        boolean[][] vis = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // If we encounter a '1' and it hasn't been visited
                if (grid[i][j] == '1' && !vis[i][j]) {
                    count++;
                    bfs(vis, grid, i, j); // Perform BFS to visit the whole island
                }
            }
        }
        System.out.println(count); // Output the number of islands (should be 2)
    }

    // BFS function to visit all connected '1's in the grid
    public static void bfs(boolean[][] vis, char[][] grid, int i, int j) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i, j));
        vis[i][j] = true; // Mark the starting cell as visited

        // Directions to move in the grid (up, right, down, left)
        int[] delrow = { -1, 0, 1, 0 };
        int[] delcol = { 0, 1, 0, -1 };

        while (!q.isEmpty()) {
            Pair polled = q.poll();
            int x = polled.x;
            int y = polled.y;

            // Explore all 4 directions
            for (int k = 0; k < 4; k++) {
                int nrow = delrow[k] + x;
                int ncol = delcol[k] + y;

                // Check boundaries and if the next cell is unvisited and land
                if (nrow >= 0 && nrow < grid.length &&
                    ncol >= 0 && ncol < grid[0].length &&
                    !vis[nrow][ncol] && grid[nrow][ncol] == '1') {

                    q.add(new Pair(nrow, ncol)); // Add the new cell to the queue
                    vis[nrow][ncol] = true; // Mark it as visited
                }
            }
        }
    }
}

