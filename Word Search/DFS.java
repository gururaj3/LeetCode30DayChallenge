Refer: https://www.youtube.com/watch?v=vYYNp0Jrdv0

class Solution {
    
    public boolean exist(char[][] board, String word) {
        
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                if(word.charAt(0) == board[i][j] && dfs(board, word, i, j, 0)){
                    return true;
                }
                
            }
            
        }
        return false;
        
    }
    
    private boolean dfs(char[][] board, String word, int i, int j, int k){
        
        if(k == word.length())
            return true;
        
        if(i<0 || j<0 || i>=board.length || j>=board[i].length || word.charAt(k) != board[i][j])
            return false;

        char temp = board[i][j];
        board[i][j] = ' ';
            
        boolean found = dfs(board, word, i+1, j, k+1) ||
                        dfs(board, word, i-1, j, k+1) ||
                        dfs(board, word, i, j+1, k+1) ||
                        dfs(board, word, i, j-1, k+1);
        board[i][j] = temp;
        return found;
        
    }
    
}
