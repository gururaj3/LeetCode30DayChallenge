class Solution {
    public int minMoves2(int[] nums) {
        
        if(nums.length == 0)
            return 0;
        
        Arrays.sort(nums);
        int mid = (nums.length-1)/2;
        int val = nums[mid];
        int count = 0;
        
        for(int i=0; i<nums.length; i++){
            if(i != mid && nums[i] != val){
                count += Math.abs(val - nums[i]);
            }
        }
        
        return count;
        
    }
}
