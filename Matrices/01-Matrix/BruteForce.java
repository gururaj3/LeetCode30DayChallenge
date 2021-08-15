class Solution {
    public int[][] updateMatrix(int[][] mat) {
        
        int r = mat.length, c = mat[0].length;
        
        for(int i=0; i<r; i++)
            for(int j=0; j<c; j++){
                
                if(mat[i][j] == 1){
                    mat[i][j] = Integer.MAX_VALUE;
                    for(int k=0; k<r; k++)
                        for(int l=0; l<c; l++)
                            if(mat[k][l] == 0)
                                mat[i][j] = Math.min(mat[i][j], Math.abs(i-k)+Math.abs(j-l));
                        
                } 
            }
        return mat;
    }
}
