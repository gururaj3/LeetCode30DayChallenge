class Solution {
    public int threeSumClosest(int[] nums, int target) {
        
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE, ans = 0;
        
        for(int i=0; i<nums.length-2; i++){
                int left = i+1;
                int right = nums.length - 1;
                
                while(left < right){
                    int sum = nums[i] + nums[left] + nums[right];
                    if (Math.abs(target - sum) < Math.abs(min)){
                        min = target - sum;
                        ans = sum;
                    }
                        
                    if (sum < target)
                        ++left;
                    else
                        --right;
                }
        }
        return ans;
    }
}


// [-1,2,1,-4]
// [-4,-1,1,2]

// [-4,-1,2] -3     4, Max
// min = 4
    
//     [-4,1,2] -1     2, 4
// min = 2
    
//     [-1,1,2] 2      -1, 2
// min = -1
