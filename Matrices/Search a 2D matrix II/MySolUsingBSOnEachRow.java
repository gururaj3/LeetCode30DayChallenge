class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int r = matrix.length;
        int c = matrix[0].length;
        
        for(int i=0; i<r; i++){
            if(matrix[i][0]<=target && matrix[i][c-1]>=target)
                if(binarySearch(i, matrix, c, target))
                    return true;
        }
        return false;
    }
    
    public boolean binarySearch(int i, int[][] matrix, int c, int target){
        int start = 0, end = c-1;
        
        while(start <= end){
            int mid = (start+end)/2;
            if(matrix[i][mid] == target)
                return true;
            if(matrix[i][mid] > target)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return false;
    }
    
}
