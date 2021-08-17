//Refer - https://www.youtube.com/watch?v=hrd-MEcZkOI

class Solution {
    public int numSubmat(int[][] mat) {  
        int row= mat.length;
        int col= mat[0].length;
        int ans= 0;
        
        int[][]dp = new int[row][col];
        
        //Calculate the sum of all one's in from right to left for each row
        for(int i = 0 ; i < row ; i++){
            int count = 0;
            for(int j = col-1 ; j >=0 ; j--){              
              if(mat[i][j] == 1){
                 count++;      
                }else{
                 count= 0;
                }
               dp[i][j] = count; 
            }         
        }
        
      //Now, for each point in the matrix->calculate all possible submatrices from that point.
      for(int i = 0 ; i < row ; i++){          
          for(int j = 0 ; j < col ; j++){
              int res = Integer.MAX_VALUE;
              for(int k = i ; k < row ; k++){
                  if(dp[k][j] == 0) break;
                  res = Math.min(dp[k][j] , res);
                  ans += res;                 
              }
          }
      }
     return ans;       
    }
}

/*

[[0,1,1,0],
 [0,1,1,1],
 [1,1,1,0]]
 
[[0,1,3,0],
 [0,3,8,1],
 [1,1,1,0]]

[[1,1,1]]->6

[[1,1,1,1]] 4+1+3+2

[[1,3,]]

*/
