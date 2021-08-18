class Solution {
    
    int[][] directions = {{0,1},{1,0},{-1,0},{0,-1}};
    int n, m;
    public int longestIncreasingPath(int[][] matrix) {
        int ans = 0;
        n=matrix.length; m=matrix[0].length;
        int[][] cache = new int[n][m];
        
        for(int i=0; i<n; i++)
            for(int j=0; j<m; j++){
                ans = Math.max(ans, dfs(i, j, matrix, cache));
            }
        
        return ans;
    }
    
    public int dfs(int i, int j, int[][] matrix, int[][] cache){
        
        if(cache[i][j] != 0){
            return cache[i][j];
        }
        
            for(int[] d : directions){
                int nr = i+d[0], nc = j+d[1];
                if(nr>=0 && nr<n && nc>=0 && nc<m && matrix[i][j] < matrix[nr][nc])       
                cache[i][j] = Math.max(dfs(nr, nc, matrix, cache), cache[i][j]);
            }
        cache[i][j] += 1;
        return cache[i][j];
    }
    
}
