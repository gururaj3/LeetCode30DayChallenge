// reference: https://www.youtube.com/watch?v=c1ZxUOHlulo

class Solution {
    public int numDistinctIslands(int[][] grid) {
        
        if(grid == null || grid.length == 0)
            return 0;
        
        int r = grid.length;
        int c = grid[0].length;
        Set<String> set = new HashSet<>();
        
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(grid[i][j] == 1){
                    String path = dfs(grid, i, j, r, c, "X");
                    set.add(path);
                }
                
            }
        }
        return set.size();
    }
    
    public String dfs(int[][] grid, int i, int j, int r, int c, String direction){
        if(i<0 || i>=r || j<0 || j>=c || grid[i][j] == 0)
            return "O";
        
        grid[i][j] = 0;
        String left = dfs(grid, i, j-1, r, c, "L");
        String right = dfs(grid, i, j+1, r, c, "R");
        String up = dfs(grid, i-1, j, r, c, "U");
        String down = dfs(grid, i+1, j, r, c, "D");
        return direction + left + right + up + down;
    }
    
}
