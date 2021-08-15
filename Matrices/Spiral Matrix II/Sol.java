class Solution {
    public int[][] generateMatrix(int n) {
        
        int[][] ans = new int[n][n];
        
        int startRow=0, startCol = 0;
        int endRow = n-1, endCol = n-1;
        int num = 1;
        while(startRow<=endRow && startCol<=endCol){
            // System.out.println(startRow+","+endRow+","+startCol+","+endCol);
            //StartRow
            for(int i=startCol; i<=endCol; i++){
                // list.add(matrix[startRow][i]);
                ans[startRow][i] = num++;
            }
            startRow++;
            
            //EndCol
            for(int i=startRow; i<=endRow; i++){
                // list.add(matrix[i][endCol]);
                ans[i ][endCol] = num++;
            }
            endCol--;
            
            //EndRow
            if(startRow<=endRow)
            for(int i=endCol; i>=startCol; i--){
                // list.add(matrix[endRow][i]);
                ans[endRow][i] = num++;
            }
            endRow--;
            
            //StartCol
            if(startCol<=endCol)
            for(int i=endRow; i>=startRow; i--){
                // list.add(matrix[i][startCol]);
                ans[i][startCol] = num++;
            }
            startCol++;
        }
        return ans;
    }
}
