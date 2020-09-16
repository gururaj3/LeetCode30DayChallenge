class Solution {
    public int pivotIndex(int[] nums) {
        
        if(nums.length == 0)
            return -1;
        
        int sum = 0, leftsum = 0;
        for(int i : nums)
            sum += i;
        
        for(int i=0; i<nums.length; i++){
            
            if( (sum - nums[i] - leftsum) == leftsum)
                return i;
            leftsum += nums[i];
            
        }
        return -1;
    }
}
