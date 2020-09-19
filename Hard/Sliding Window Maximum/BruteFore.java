class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        List<Integer> list = new ArrayList<>();
        
        for(int i=0; i<nums.length-k+1; i++){
            int temp = 0;
            int j = i;
            List<Integer> l = new ArrayList<>();
            while(temp<k){
                
                l.add(nums[j]);
                j = j+1;
                temp++;
            }
            
            list.add(Collections.max(l));
        }
        
        int[] output = new int[list.size()];
        
        for(int i=0; i<list.size(); i++){
            output[i] = list.get(i);
        }
        
        return output;
    }
}
