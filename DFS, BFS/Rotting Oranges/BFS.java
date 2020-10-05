class Solution {
    public int orangesRotting(int[][] grid) {
        
        if(grid.length == 0 || (grid.length == 1 && grid[0].length == 1 && grid[0][0] == 0 ) )
            return 0;
        
        int nr = grid.length;
        int nc = grid[0].length;
        
        List<int[]> directions = Arrays.asList(
            new int[] {1, 0},
            new int[] {-1, 0},
            new int[] {0, 1},
            new int[] {0, -1}
        );
        
        Queue<int[]> q = new LinkedList<>();
        
        for(int i=0; i<nr; i++){
            for(int j=0; j<nc; j++){
                if(grid[i][j] == 2){
                    q.add(new int[] {i, j, 0});
                }
            }
        }
        
        if(q.isEmpty())
            return -1;
        
        int count = 0;
        while(!q.isEmpty()){
            int[] pos = q.poll();
            int row = pos[0];
            int col = pos[1];
            count = pos[2];
            
            for(int[] i : directions){
                int r = row + i[0];
                int c = col + i[1];
                if(r<0 || r>=nr || c<0 || c>=nc || grid[r][c] == 0 || grid[r][c] == 2)
                    continue;
                grid[r][c] = 2;
                q.add(new int[] {r, c, count+1});
                
            }
            
        }
        
        for(int i=0; i<nr; i++){
            for(int j=0; j<nc; j++){
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }
        return count;
    }
}
