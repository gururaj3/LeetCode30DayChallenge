class Solution {
    public int[] findErrorNums(int[] nums) {
        
        Map<Integer, Integer> map = new HashMap<>();
        int duplicateNum = 0, missing = 0;
        for (int i=0; i< nums.length; i++){
            if(map.containsKey(nums[i])){
                duplicateNum = nums[i];
            }
            else{
                map.put(nums[i], i);
            }
            
        }
    
        for(int i=1; i<=nums.length; i++){
            if( !map.containsKey(i))
                missing = i;
        }
        
        return new int[] {duplicateNum, missing};
        
    }
}