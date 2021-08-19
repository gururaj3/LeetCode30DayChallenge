class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        int n=obstacleGrid.length, m=obstacleGrid[0].length;
        
        if(obstacleGrid[0][0] == 1 || obstacleGrid[n-1][m-1] == 1)
            return 0;
        //Traverse obstacleGrid to change obstacle to -1
        for(int i=0; i<n; i++)
            for(int j=0; j<m; j++){
                if(obstacleGrid[i][j] == 1)
                    obstacleGrid[i][j] = -1;
            }
        //Traverse First Row
        for(int i=0; i<1; i++)
            for(int j=0; j<m; j++){
                if(obstacleGrid[i][j] == -1)
                    break;
                else
                    obstacleGrid[i][j] = 1;
            }
        
        //Traverse First Column
        for(int i=0; i<n; i++)
            for(int j=0; j<1; j++){
                if(obstacleGrid[i][j] == -1)
                    i=n;
                else
                    obstacleGrid[i][j] = 1;
            }
        
        // obstacleGrid[0][0] = 1;
        // for(int i=0; i<n; i++)
        //     for(int j=0; j<m; j++){
        //         System.out.println(obstacleGrid[i][j]);
        //     }
        
        //Traverse obstacleGrid to update values
        for(int i=1; i<n; i++)
            for(int j=1; j<m; j++){
                if(obstacleGrid[i][j] != -1){
                    if(obstacleGrid[i-1][j] == -1 && obstacleGrid[i][j-1] == -1)
                    obstacleGrid[i][j] = -1;
                    else if(obstacleGrid[i-1][j] == -1)
                        obstacleGrid[i][j] = obstacleGrid[i][j-1];
                    else if(obstacleGrid[i][j-1] == -1)
                        obstacleGrid[i][j] = obstacleGrid[i-1][j];
                    else
                        obstacleGrid[i][j] = obstacleGrid[i-1][j]+obstacleGrid[i][j-1];
                }
                
            }
        return obstacleGrid[n-1][m-1] == -1 ? 0 : obstacleGrid[n-1][m-1];
    }
}
