class Solution {
    public int search(int[] nums, int target) {
        
        int i=0, j = nums.length-1;
        int smallestElement  = 0;
        
        while(i<j){
            
            int mid = (i+j)/2;
            if(nums[mid] == nums[j]){
                smallestElement = j;
                break;
            } 
            else if(nums[mid] < nums[j])
                j = mid;
            else
                i = mid+1;
            
        }
        smallestElement = i;

        
        if(nums[smallestElement] == target)
            return smallestElement;
        else if(nums[smallestElement] < target && target <= nums[nums.length-1]){
            i = smallestElement+1;
            j = nums.length-1;
        }   
        else{
            j = smallestElement-1;
            i = 0;
        }
        
        while(i<=j){
            
            int mid = (i+j)/2;
            if(nums[mid] == target)
                 return mid;
            else if(nums[mid] < target)
                i = mid+1;
            else
                j = mid-1;     
        }
        return -1;
    }
}
