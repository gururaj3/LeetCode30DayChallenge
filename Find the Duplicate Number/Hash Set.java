class Solution {
    public int findDuplicate(int[] nums) {
        
        Set<Integer> isDuplicate = new HashSet<>();
        
        for(int i=0; i<nums.length; i++){
            if(isDuplicate.contains(nums[i]))
                return nums[i];
            else
                isDuplicate.add(nums[i]);
        }
        return -1;
        
    }
}