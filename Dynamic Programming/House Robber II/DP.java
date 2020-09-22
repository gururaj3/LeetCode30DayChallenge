class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        
        int[] dp = new int[nums.length+1];
        dp[0] = 0;
        dp[1] = nums[0];
        
        for(int i=1; i<nums.length-1; i++){
            dp[i+1] = Math.max(dp[i], dp[i-1]+ nums[i]);
        }
        
        int[] dp1 = new int[nums.length+1];
        dp1[0] = 0;
        dp1[1] = nums[1];
        
        for(int i=2; i<nums.length; i++){
            dp1[i] = Math.max(dp1[i-1], dp1[i-2]+ nums[i]);
        }
        
        return Math.max(dp[nums.length-1], dp1[nums.length-1]);
    }
}
