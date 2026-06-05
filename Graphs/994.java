import java.util.*;

class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        
        boolean vis[][] = new boolean[rows][cols];
        
        int ans = 0; 
        int freshCount = 0;
        
        Queue<int[]> q = new LinkedList<>();
        
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[]{i, j, 0});
                    vis[i][j] = true;
                } else if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }
        
        if (freshCount == 0) return 0;

        while (!q.isEmpty()) {
            int[] item = q.poll();
            int i = item[0];
            int j = item[1];
            int time = item[2];
            
            ans = Math.max(ans, time);
            
            // TOP
            if (i - 1 >= 0 && !vis[i - 1][j] && grid[i - 1][j] == 1) {
                q.add(new int[]{i - 1, j, time + 1}); 
                vis[i - 1][j] = true;
                freshCount--; 
            }
            
            // BOTTOM
            if (i + 1 < rows && !vis[i + 1][j] && grid[i + 1][j] == 1) {
                q.add(new int[]{i + 1, j, time + 1});
                vis[i + 1][j] = true;
                freshCount--;
            }
            
            // LEFT
            if (j - 1 >= 0 && !vis[i][j - 1] && grid[i][j - 1] == 1) {
                q.add(new int[]{i, j - 1, time + 1});
                vis[i][j - 1] = true;
                freshCount--;
            }
            
            // RIGHT
            if (j + 1 < cols && !vis[i][j + 1] && grid[i][j + 1] == 1) {
                q.add(new int[]{i, j + 1, time + 1});
                vis[i][j + 1] = true;
                freshCount--;
            }
        }
        return freshCount == 0 ? ans : -1;
    }
}
