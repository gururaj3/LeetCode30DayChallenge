class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        
        int rows = nums.length;
        int columns = nums[0].length;
        int[][] m = new int[r][c];
        List<Integer> l = new ArrayList<>();
        
        for(int i=0; i<rows;i++){
                for(int j=0; j<columns;j++){
                    l.add(nums[i][j]);
                }
            }
        int k =0;
        if(rows*columns == r*c){
            for(int i=0; i<r;i++){
                for(int j=0; j<c;j++){
                    m[i][j] = l.get(k);
                    k++;
                }
            }
            return m;
        }
        else{
            return nums;
        }
        
    }
}
