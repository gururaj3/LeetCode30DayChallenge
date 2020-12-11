class Solution {
    public void gameOfLife(int[][] board) {
        
        int n = board.length;
        int m = board[0].length;
        int[][] copy = new int[n][m];
        int[] neighbours = new int[]{0,1,-1};
        
        for(int i=0; i<n; i++)
            for(int j=0; j<m; j++)
                copy[i][j] = board[i][j];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                
                int l = 0;
                
                //right
                if(j+1<m && copy[i][j+1] == 1){
                    l++;
                }
                //left
                if(j-1>=0 && copy[i][j-1] == 1){
                    l++;
                }
                //top
                if(i-1>=0 && copy[i-1][j] == 1){
                    l++;
                }
                //bottom
                if(i+1<n && copy[i+1][j] == 1){
                    l++;
                }
                //top-right
                if(j+1<m && i-1>=0 && copy[i-1][j+1] == 1){
                    l++;
                }
                //top-left
                if(j-1>=0 && i-1>=0 && copy[i-1][j-1] == 1){
                    l++;
                }
                //bottom-left
                if(j-1>=0 && i+1<n && copy[i+1][j-1] == 1){
                    l++;
                }
                //bottom-right
                if(j+1<m && i+1<n && copy[i+1][j+1] == 1){
                    l++;
                }
                
               if(l<2 && board[i][j] == 1)
                   board[i][j] = 0;
               else if(l>3 && board[i][j] == 1)
                   board[i][j] = 0;
               else if(l==3 && board[i][j] == 0)
                   board[i][j] = 1;
                
            }
        }
        
    }
}
