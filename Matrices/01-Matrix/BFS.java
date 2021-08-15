class Solution {
    public int[][] updateMatrix(int[][] mat) {
        
        int r = mat.length, c = mat[0].length;
        Queue<int[]> q = new LinkedList<>();
           
        for(int i=0; i<r; i++)
            for(int j=0; j<c; j++){
                if(mat[i][j] == 0)
                    q.add(new int[]{i, j});
            }
        
        int[][] directions = { {-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int count = 1;
        
        while(!q.isEmpty()){
            
            int len = q.size();
            for(int i=0; i<len; i++){
                    int[] pos = q.poll();
                    int row = pos[0], col = pos[1];
                
                    for (int[] d : directions) {
                    int neighborRow = row + d[0];
                    int neighborCol = col + d[1];
                    
                    if(neighborRow >= 0 && neighborCol >= 0 && neighborRow < r && neighborCol < c && mat[neighborRow][neighborCol] == 1){
                        if(count==1){
                            mat[neighborRow][neighborCol] = -1;
                        }
                        else{
                            mat[neighborRow][neighborCol] = count;
                        }
                        q.add(new int[]{neighborRow, neighborCol});
                    }
                }
            }
            count++;
        }
        
        // for(int i=0; i<r; i++)
        //     for(int j=0; j<c; j++){
        //         System.out.println(mat[i][j]+" ");
        //     }
        
        for(int i=0; i<r; i++)
            for(int j=0; j<c; j++){
                if(mat[i][j] == -1)
                    mat[i][j] = 1;
            }
        return mat;
    }
}
