class Solution {
    public int climbStairs(int n) {
        
        int[] memo = new int[n+1];  
        return recursive_func(0, n, memo);
    }
    
    public int recursive_func(int i, int n, int[] memo){
        
        if(i>n)
            return 0;
        if(i==n)
            return 1;
        if(memo[i]>0)
            return memo[i];
        memo[i] = recursive_func(i+1, n, memo) + recursive_func(i+2, n, memo);
        
        return memo[i];
        
    }
    
}

/*

n=2
1+1
2

n=3
1+1+1
1+2
2+1

n=4
1+1+1+1
1+2+1
2+1+1
2+1+1
2+2


Using DP:

        0       1       2       3       4       5
    dp  0       1       2       3       5       8           -> Number of distinct ways
        
Ways            1      1+1    1+1+1
                        2      2+1
                               1+2
                               
So, now let's say you want to cal number of distinct ways to reach 4:

    To reach 4: 1. You can take 1 step from 3 
                    1+1+1 +1
                     2+1  +1
                     1+2  +1
                2. You can take 2 steps from 2
                     1+1 +2
                      2  +2
                      
Hence, you get dp[i] = dp[i-1] + dp[i-2]
*/
