class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        if(nums.length == 0)
            return new int[] {-1,-1};
        if(nums.length == 1 && nums[0]==target)
            return new int[] {0,0};
        if(nums.length == 1 && nums[0]!=target)
            return new int[] {-1,0-1};
        
        int start = 0;
        int end = nums.length-1;
        int mid = -1, i = -1, j = -1;
        
        while(mid>-2 && start!=mid && end!=mid){
            
            mid = start + (end-start)/2;
            
            if(nums[mid] == target){
                
                int mid1 = mid;
                if(mid-1>=0 && nums[mid-1] == target)
                    while(mid-1>=0 && nums[--mid] == target)
                        j = mid;
                else
                    j = mid;
                
                if(mid1+1<=nums.length-1 && nums[mid1+1] == target)
                    while(mid1+1<=nums.length-1 && nums[++mid1] == target)
                        i = mid1;
                else
                    i = mid1;
                
                break;
            }
            else if(nums[mid] < target){
                start = mid + 1;
            }
            else
                end = mid - 1;
            
        }
        if(i>=0 && j>= 0)
            return new int[] {j,i};
        else 
            return new int[] {-1,-1};
    }
}