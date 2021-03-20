class Solution {
    public int deleteAndEarn(int[] nums) {
        
        int[] buckets = new int[10001];
        for (int i = 0; i < nums.length; i++) {
            buckets[nums[i]] += nums[i];
        } 

        //House Robber solution
        int[] dp = new int[buckets.length];              //can be replaced by two vars
        dp[0] = buckets[0];
        dp[1] = Math.max(buckets[0], buckets[1]);
        for (int i = 1; i < buckets.length-1; i++) {
            dp[i+1] = Math.max(dp[i], dp[i-1] + buckets[i]);
        }
        
        return dp[buckets.length-1];
    }
}
