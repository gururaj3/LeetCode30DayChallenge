// Refer - https://www.youtube.com/watch?v=pmQAtRZ3CuE

class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        
        int len = jobDifficulty.length;
        
        if(d > len)
            return -1;
        
        int[][] dp = new int[d+1][len];
        for(int[] p : dp)
            Arrays.fill(p, -1);
        return dfs(jobDifficulty, d, dp, 0);
        
    }
    
    public int dfs(int[] jobDifficulty, int d, int[][] dp, int splitIdx){
        
        if(d == 1){
            int max = 0;
            while(splitIdx < jobDifficulty.length){
                max = Math.max(max, jobDifficulty[splitIdx++]);
            }
            return max;
        }
        
        if(dp[d][splitIdx] != -1)
            return dp[d][splitIdx];
        
        int max = 0;
        int res = Integer.MAX_VALUE;
        for(int i=splitIdx; i<jobDifficulty.length - d + 1; i++){
            max = Math.max(max, jobDifficulty[i]);
            res = Math.min(res, max + dfs(jobDifficulty, d-1, dp, i+1));
        }
        dp[d][splitIdx] = res;
        return dp[d][splitIdx];
        
        
    }
    
}

/*
Given an array, cut it into d contiguous subarray and return the minimum sum of max of each subarray.

arr = [6,5,4,3,2,1], d = 2
You must split the arr into 2 subarrays. The minimum obtained would be:
[6,5,4,3,2] [1] -> 6 + 1 = 7

Total options would be:
[6] [5,4,3,2,1] -> 6 + 5 = 11
[6,5] [4,3,2,1] -> 6 + 4 = 10
[6,5,4] [3,2,1] -> 6 + 3 = 9
[6,5,4,3] [2,1] -> 6 + 2 = 8
[6,5,4,3,2] [1] -> 6 + 1 = 7


Space is O(N*d) because that is the matrix size that we create. Time is O(N*N*d). Instead of trying to explain the time complexity using loops, I want you to imagine this instead: what does the code do? It finds all of the unique ways to spilt an array of sized N into d parts. Imagine we have an array of size 100. If d is 1, then we don't need to make a cut O(1). If d is 2, we need to attempt a cut at 99 locations O(N). If d is 3, we make a cut at point 1, then one between 1-99. Then at 2 and one between 2-99, etc O(N*2). If d is 4, we make a cut at point 1, point 2, and third point 3-99, etc O(N*3). So the cuts take O((N-1)*(d-1)) = O(N*d). The second N comes from finding the max of each subarray.

This algorithm can be further optimized to only find the max once and reduce the time to O(N*d). A solution for this optimized version can be found in the discussion tab of the leetcode question but I thought it was a bit too hard to explain in plain terms.

*/
