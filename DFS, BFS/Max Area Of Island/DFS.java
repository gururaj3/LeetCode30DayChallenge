//Do Number of Islands before this, it is based on that concept

class Solution {
    int co;
    public int maxAreaOfIsland(int[][] grid) {
        
        if(grid.length == 0)
            return 0;
        
        int r = grid.length;
        int c = grid[0].length;
        int count = 0;
        
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(grid[i][j] == 1){
                    co = 0;
                    count = Math.max(count, dfs(grid, i, j));
                }
            }
        }
        return count;
    }
    
    public int dfs(int[][] grid, int i, int j){
        
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j] == 0)
            return 0;
        co++;
        grid[i][j] = 0;
        
        dfs(grid, i+1, j);
        dfs(grid, i-1, j);
        dfs(grid, i, j+1);
        dfs(grid, i, j-1);
        
        return co;
    }
    
}
