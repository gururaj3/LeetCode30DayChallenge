class Solution {
    public int islandPerimeter(int[][] grid) {
        
        int res = 0;
        
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                int count = 0;
                if(grid[i][j] == 1){
                    count = 4;
                    
                    if(i-1>=0  && grid[i-1][j] == 1){
                        count -= 1;
                    }
                    if(j+1<grid[0].length && grid[i][j+1] == 1){
                        count -= 1;
                    }
                    if(j-1>=0 && grid[i][j-1] == 1){
                        count -= 1;
                    }
                    if(i+1<grid.length && grid[i+1][j] == 1){
                        count -= 1;
                    }
                }
                res += count;
            }
        }
        return res;
        
    }
}
