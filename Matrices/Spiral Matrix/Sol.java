class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        List<Integer> list = new ArrayList<>();
        
        int r = matrix.length, c = matrix[0].length;
        
        int startRow=0, startCol = 0;
        int endRow = matrix.length-1, endCol = matrix[0].length-1;
        
        while(startRow<=endRow && startCol<=endCol){
            // System.out.println(startRow+","+endRow+","+startCol+","+endCol);
            //StartRow
            for(int i=startCol; i<=endCol; i++){
                list.add(matrix[startRow][i]);
            }
            startRow++;
            
            //EndCol
            for(int i=startRow; i<=endRow; i++){
                list.add(matrix[i][endCol]);
            }
            endCol--;
            
            //EndRow
            if(startRow<=endRow)
            for(int i=endCol; i>=startCol; i--){
                list.add(matrix[endRow][i]);
            }
            endRow--;
            
            //StartCol
            if(startCol<=endCol)
            for(int i=endRow; i>=startRow; i--){
                list.add(matrix[i][startCol]);
            }
            startCol++;
        }
        return list;
    }
}
