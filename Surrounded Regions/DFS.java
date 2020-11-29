class Solution {
    public void solve(char[][] board) {
        
        if(board.length != 0){
        
            for(int i=0; i<board[0].length; i++){
                if(board[0][i] == 'O'){
                    dfs(board, 0, i);
                }

                if(board[board.length-1][i] == 'O'){ 
                    dfs(board, board.length-1, i);
                }

            }

            for(int i=0; i<board.length; i++){
                if(board[i][0] == 'O'){
                    dfs(board, i, 0);
                }

                if(board[i][board[0].length-1] == 'O'){
                    dfs(board, i, board[0].length-1);
                }

            }

            for(int i=0; i<board.length; i++){
                for(int j=0; j<board[0].length; j++){
                    if(board[i][j] == '*'){
                        board[i][j] = 'O';
                    }
                    else if(board[i][j] == 'O'){
                        board[i][j] = 'X';
                    }
                }
            }
        
        }
        
    }
    
    private int dfs(char[][] board, int i, int j){
        
        if(i<0 || j<0 || i>=board.length || j>=board[i].length || board[i][j] == 'X' || board[i][j] == '*')
            return 0;
        
        board[i][j] = '*';
        dfs(board, i+1, j);
        dfs(board, i-1, j);
        dfs(board, i, j+1);
        dfs(board, i, j-1);
        
        return 1;
        
    }
    
}
