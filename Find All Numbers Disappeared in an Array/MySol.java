class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        
        if(nums.length == 0)
            return list;
        
        for(int i:nums)
            set.add(i);
        
        for(int i=1; i<=nums.length; i++){
            if(!set.contains(i)){
                list.add(i);
            }
        }
        return list;
    }
}
