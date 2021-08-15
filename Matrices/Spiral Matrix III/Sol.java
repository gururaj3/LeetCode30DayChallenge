class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int n = rows*cols;

        int rowStart = rStart, rowEnd = rStart+1;
        int colStart = cStart, colEnd = cStart+1;
        int[][] ans = new int[cols*rows][2];
        int pos = 0;
        
        while (pos != n) {
            
            for (int j = colStart; j <= colEnd; j++) {
                if (isValid(rowStart, j, rows, cols)) {
                    ans[pos++] = new int[]{rowStart, j};
                }
            }
            
            for (int i = rowStart+1; i <= rowEnd; i++) {
                if (isValid(i, colEnd, rows, cols)) {
                    ans[pos++] = new int[]{i, colEnd};
                }
            }
            for (int j = colEnd-1; j >= colStart-1; j--) {
                if (isValid(rowEnd, j, rows, cols)) {
                    ans[pos++] = new int[]{rowEnd, j};
                }
            }
            for (int i = rowEnd-1; i >= rowStart; i--) {
                if (isValid(i, colStart-1, rows, cols)) {
                    ans[pos++] = new int[]{i, colStart-1};
                }
            }
            //Expand the square
            rowStart--;
            colStart--;
            rowEnd++;
            colEnd++;
        }
        return ans;
    }
    
    private boolean isValid(int i, int j, int rows, int cols) {
        return (i >= 0 && i < rows && j >= 0 && j < cols);
    }
}
