//Refer - https://www.youtube.com/watch?v=Z2h3rkVXPeQ


//The idea is to traverse each row and column considering it as the bottom right corner of a square matrix, and accordingly calculate the number of matrixes.
class Solution {
    public int countSquares(int[][] matrix) {
        
        int r = matrix.length, c = matrix[0].length;
        
        int ans = 0;
        for(int i=0; i<r; i++)
            for(int j=0; j<c; j++){
                if(matrix[i][j] == 1){
                    //if first row or first column->just add to answer
                    if(i==0 || j==0){
                    ans += matrix[i][j];
                    }
                    //otherwise update the value of the matrix to be the minimum of previous row, column, diagonal and add it to the ans
                    else{
                        matrix[i][j] = Math.min(Math.min(matrix[i-1][j], matrix[i][j-1]), matrix[i-1][j-1]) +1;
                        ans += Math.min(Math.min(matrix[i-1][j], matrix[i][j-1]), matrix[i-1][j-1]) +1;
                    }
                }  
            }
        
        return ans;
    }
}

/*
*/
