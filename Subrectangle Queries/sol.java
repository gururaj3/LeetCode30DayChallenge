class SubrectangleQueries {

    int[][] rect;
    public SubrectangleQueries(int[][] rectangle) {
        this.rect = rectangle;
    }
    
    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        // for(int i=row1; i<=row2; i++)
        //     for(int j=col1; j<=col2; j++)
        //         rect[i][j] = newValue;
        
        for (int r = row1; r<row2+1;r++)
     {
 	// Arrays.fill is faster than iterating through everything
         Arrays.fill(rect[r], col1, col2+1, newValue);
     }
    }
    
    public int getValue(int row, int col) {
        return rect[row][col];
    }
}

/**
 * Your SubrectangleQueries object will be instantiated and called as such:
 * SubrectangleQueries obj = new SubrectangleQueries(rectangle);
 * obj.updateSubrectangle(row1,col1,row2,col2,newValue);
 * int param_2 = obj.getValue(row,col);
 */
