class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        
        List<String> ans = new ArrayList<>();
        
        for(String str : words){
            for(int i=0; i<board.length; i++){
                for(int j=0; j<board[i].length; j++){

                        if(board[i][j] == str.charAt(0)){
                            if(dfs(board, str, i, j, 0)){
                            if(!ans.contains(str))
                                ans.add(str);
                            }
                        }
                }
            }
        }
        return ans;
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
