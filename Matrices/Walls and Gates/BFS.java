class Solution {
    public void wallsAndGates(int[][] rooms) {
        
        int EMPTY = Integer.MAX_VALUE;
        int GATE = 0;
        List<int[]> DIRECTIONS = Arrays.asList(
            new int[] {1, 0},
            new int[] {-1, 0},
            new int[] {0, 1},
            new int[] {0, -1}
        );
        
        if(rooms.length == 0)
            return;
        
        int nr = rooms.length;
        int nc = rooms[0].length;
        Queue<int []> q = new LinkedList<>();
        
        for(int i=0; i<nr; i++){
            for(int j=0; j<nc; j++){
                if(rooms[i][j] == GATE){
                    q.add(new int[] {i, j});
                }
            }
        }
        
        while(!q.isEmpty()){
            int[] pos = q.poll();
            int row = pos[0];
            int col = pos[1];
            
            for(int [] direction : DIRECTIONS){
                int r = row + direction[0];
                int c = col + direction[1];
                if(r<0 || c<0 || r>=nr || c>=nc || rooms[r][c] != EMPTY)
                    continue;
                rooms[r][c] = rooms[row][col] + 1;
                q.add(new int[] {r, c}); 
            }
        }
    }
}
