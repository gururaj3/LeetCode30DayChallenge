class TicTacToe {

    /** Initialize your data structure here. */
    int grid[][];
    int n;
    public TicTacToe(int n) {
        this.grid = new int[n][n];
        this.n = n;
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        
        if(player == 1){
            grid[row][col] = 1;
        }
        else if(player == 2){
            grid[row][col] = 2;
        }
        
        //Player 1
        int i=0;
        while(i<n && grid[row][i] == 1){
            i++;
        }
        if(i==grid[0].length)
            return 1;
        
        i=0;
        while(i<n && grid[i][col] == 1){
            i++;
        }
        if(i==grid.length)
            return 1;
        
        i=0;
        int j=0;
        while(i<n && j<n && grid[i][j] == 1){
            i++;
            j++;
        }
        if(i == n && j == n)
            return 1;
        
        i=0;
        j=n-1;
        while(i<n && j>=0 && grid[i][j] == 1){
            i++;
            j--;
        }
        if(i == n && j == -1)
            return 1;
        
        //Player 2
        i=0;
        while(i<n && grid[row][i] == 2){
            i++;
        }
        if(i==grid[0].length)
            return 2;
        
        i=0;
        while(i<n && grid[i][col] == 2){
            i++;
        }
        if(i==grid.length)
            return 2;
        
        i=0;
        j=0;
        while(i<n && j<n && grid[i][j] == 2){
            i++;
            j++;
        }
        if(i == n && j == n)
            return 2;
        
        i=0;
        j=n-1;
        while(i<n && j>=0 && grid[i][j] == 2){
            i++;
            j--;
        }
        if(i == n && j == -1)
            return 2;

        return 0;
    }
}

// |X| |O|
// |X|O| |
// | | |X|

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
