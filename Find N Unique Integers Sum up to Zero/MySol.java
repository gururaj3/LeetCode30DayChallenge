class Solution {
    public int[] sumZero(int n) {
        
        int[] nums = new int[n];
        
        if(n%2 == 0){
            for(int i=0; i<n; i++){
                nums[i] = i+1;
                i++;
                nums[i] = -i;
            }
        }
        else{
            nums[0] = 0;
            for(int i=1; i<n; i++){
                nums[i] = i+1;
                i++;
                nums[i] = -i;
            }
        }
        return nums;
    }
}
