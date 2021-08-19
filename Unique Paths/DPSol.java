class Solution {
    public int uniquePaths(int m, int n) {
        
        int[][] matrix = new int[m][n];
        
        for(int i=0; i<1; i++)
            for(int j=0; j<n; j++){
                matrix[i][j] = 1;
            }
        for(int i=0; i<m; i++)
            for(int j=0; j<1; j++){
                matrix[i][j] = 1;
            }
        
        for(int i=1; i<m; i++)
            for(int j=1; j<n; j++){
                matrix[i][j] = matrix[i-1][j]+matrix[i][j-1];
            }
        return matrix[m-1][n-1];
        
    }
}

// [0,1,1,1,1,1,1]
// [1,2,3,4,5,6,7]
// [1,3,6,10,15,21,28]
