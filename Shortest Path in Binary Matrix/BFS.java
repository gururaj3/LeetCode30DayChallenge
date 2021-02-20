class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        
        if(grid[0][0] != 0)
            return -1;
        
        Queue<int[]> q = new LinkedList<>();
        grid[0][0] = 1;
        q.add(new int[]{0, 0});
        
        while(!q.isEmpty()){
            int[] pos = q.poll();
            if(pos[0] == grid.length-1 && pos[1] == grid[0].length-1){
                return grid[pos[0]][pos[1]];
            }
            
            //down
            if(pos[0]+1<grid.length && grid[pos[0]+1][pos[1]] == 0){
                    q.add(new int[]{pos[0]+1, pos[1]});
                    grid[pos[0]+1][pos[1]] = grid[pos[0]][pos[1]] + 1;
            }
            //up
            if(pos[0]-1>=0 && grid[pos[0]-1][pos[1]] == 0){
                q.add(new int[]{pos[0]-1, pos[1]});
                grid[pos[0]-1][pos[1]] = grid[pos[0]][pos[1]] + 1;
            }
            //right
            if(pos[1]+1<grid[0].length && grid[pos[0]][pos[1]+1] == 0){
                q.add(new int[]{pos[0], pos[1]+1});
                grid[pos[0]][pos[1]+1] = grid[pos[0]][pos[1]] + 1;
            }
            //left
            if(pos[1]-1>=0 && grid[pos[0]][pos[1]-1] == 0){
                q.add(new int[]{pos[0], pos[1]-1});
                grid[pos[0]][pos[1]-1] = grid[pos[0]][pos[1]] + 1;
            }
            //top-left
            if(pos[1]-1>=0 && pos[0]-1>=0 && grid[pos[0]-1][pos[1]-1] == 0){
                q.add(new int[]{pos[0]-1, pos[1]-1});
                grid[pos[0]-1][pos[1]-1] = grid[pos[0]][pos[1]] + 1;
            }
            //top-left-down
            if(pos[1]-1>=0 && pos[0]+1<grid.length && grid[pos[0]+1][pos[1]-1] == 0){
                q.add(new int[]{pos[0]+1, pos[1]-1});
                grid[pos[0]+1][pos[1]-1] = grid[pos[0]][pos[1]] + 1;
            }
            //top-right
            if(pos[1]+1<grid[0].length && pos[0]-1>=0 && grid[pos[0]-1][pos[1]+1] == 0){
                q.add(new int[]{pos[0]-1, pos[1]+1});
                grid[pos[0]-1][pos[1]+1] = grid[pos[0]][pos[1]] + 1;
            }
            //top-right-down
            if(pos[1]+1<grid[0].length && pos[0]+1<grid.length && grid[pos[0]+1][pos[1]+1] == 0){             
                q.add(new int[]{pos[0]+1, pos[1]+1});
                grid[pos[0]+1][pos[1]+1] = grid[pos[0]][pos[1]] + 1;
            }  
        }
        return -1;
    }
}
