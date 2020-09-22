class Solution {
    public int minCostII(int[][] costs) {
        
        if(costs.length == 0)
            return 0;
        
        int n = costs.length;
        int k = costs[0].length;
        
        for(int i=1; i<n; i++){
            for(int j=0; j<k; j++){
                int min = Integer.MAX_VALUE;
                for(int c=0; c<k; c++){
                    if(j == c)
                        costs[i][j] += 0;
                    else{
                        
                        min = Math.min(costs[i-1][c], min);
                    }
                        
                }
                costs[i][j] += min;
                
            }
        }
        
        int result = Integer.MAX_VALUE;
        for(int j=0; j<k; j++){
            result = Math.min(costs[n-1][j], result);
        }
        return result;
    }
}
