class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        
        if(matrix.length == 0 || matrix == null)
            return new int[0];
        
        int n = matrix.length;
        int m = matrix[0].length;
        int k = 0;
        
        int result[] = new int[n*m];
        List<Integer> tempList = new ArrayList<>();
        
        for(int d=0; d<n+m-1; d++){
            
            tempList.clear();
            
            int r = d<m ? 0 : d-m+1;
            int c = d<m ? d : m-1;
            
            while(r<n && c>-1){
                tempList.add(matrix[r++][c--]);
            }
            
            if(d%2 == 0)
                Collections.reverse(tempList);
            
            for(int j : tempList)
                result[k++] = j;
            
        }
        return result;
    }
}
