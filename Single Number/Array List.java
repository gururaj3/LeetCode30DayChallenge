class Solution {
    public int singleNumber(int[] nums) {
        
        List<Integer> list = new ArrayList<Integer>();
        
        for(int i=0; i<nums.length; i++){
            if(list.contains(nums[i])){
                int index = list.indexOf(nums[i]);
                list.remove(index);
            }
            else
                list.add(nums[i]);
        }
        return list.get(0);
    }
}