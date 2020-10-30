//Refered https://www.youtube.com/watch?v=MnD8KhBHgRo

class Solution {
    public int closedIsland(int[][] grid) {
        
        if(grid == null || grid.length == 0)
            return 0;
        
        int r = grid.length;
        int c = grid[0].length;
        int count = 0;
        
        for(int i=1; i<r-1; i++){
            for(int j=1; j<c-1; j++){
                if(grid[i][j] == 0){
                    if(isClosed(grid, i, j, r, c))
                        count++;
                }
            }
        }
        return count;
    }
    
    public boolean isClosed(int[][] grid, int i, int j, int r, int c){
        if(grid[i][j] == -1 || grid[i][j]==1)
            return true;
        if(isPerimeter(i, j, r, c)) return false;
        
        grid[i][j] = -1;
        boolean left = isClosed(grid, i, j-1, r, c);
        boolean right = isClosed(grid, i, j+1, r, c);
        boolean up = isClosed(grid, i-1, j, r, c);
        boolean down = isClosed(grid, i+1, j, r, c);
        return left && right && up && down;
    }
    
    public boolean isPerimeter(int i, int j, int r, int c){
        if(i==0 || j ==0 || i==r-1 || j==c-1)
            return true;
        return false;
    }
}
