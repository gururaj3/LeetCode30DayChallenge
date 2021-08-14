// This solution is written with respect to the solution of Number of Islands

class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        
        List<Integer> result = new ArrayList<>();
        
        if(m ==0 && n== 0)
            return result;
        
        char[][] grid = new char[m][n];
        int count = 0;
        
        for(int i=0; i<grid.length; i++)
            for(int j = 0; j<grid[0].length; j++)
                grid[i][j] = '0';
        
        for(int i=0; i<positions.length; i++){
                grid[positions[i][0]][positions[i][1]] = '1';
            char[][] matrix = new char[m][n];
                for(int p=0; p<grid.length; p++)
                            for(int q = 0; q<grid[0].length; q++)
                                matrix[p][q] = grid[p][q];
            for(int l=0; l<m; l++)
            for(int p=0; p<n; p++)
                for(int a=0; a<m; a++){
                    for(int b=0; b<n; b++){
                        if(matrix[a][b] == '1'){
                            count += dfs(matrix, a, b);
                        }  
                    }
                }
            result.add(count);
            count = 0;
        }
        return result;
    }
    
    public int dfs(char[][] matrix, int i, int j){
        int m = matrix.length;
        int n = matrix[0].length;
        if(i<0 || i>=m || j<0 || j>=n || matrix[i][j]=='0')
            return 0;
        matrix[i][j] = '0';
        dfs(matrix, i+1, j);
        dfs(matrix, i-1, j);
        dfs(matrix, i, j+1);
        dfs(matrix, i, j-1);
        return 1;
    }
}
