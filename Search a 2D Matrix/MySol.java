class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int r = matrix.length;
        int c = matrix[0].length;
        
        for(int i=0; i<r; i++){
            if(target<=matrix[i][c-1] && target>=matrix[i][0]){
                return binarySearch(i, c, matrix, target);
            }
        }
        return false;
    }
    
    public boolean binarySearch(int i, int c, int[][] matrix, int target){
        int start = 0, end = c-1;
        while(start<=end){
            int mid = (start+end)/2;
            
            if(matrix[i][mid] == target)
                return true;
            if(matrix[i][mid] > target)
                end = mid-1;
            else
                start = mid + 1;
            
        }
        return false;
    }
    
}
// [[1,3,5,7],
//  [10,11,16,20],
//  [23,30,34,60]]
 
// bS(1, 4, matrix, target){
//     start = 0, end = 3;
    
//     while(start<end){
//         mid = 1;
//         start = 2;
        
//     }
//     while(start<end){
//         mid = 2;
//         end = 2;
        
//     }
// }


// 1. First find row
// 2. Apply BS
