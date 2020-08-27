class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        List<Integer> l = new ArrayList<>();
        
        for (int i : nums)
            l.add(i);
        
        for(int i=0; i<l.size(); i++){
            if(l.contains(target - l.get(i)) && l.indexOf(target - l.get(i)) != i)
                return new int[] {i, l.indexOf(target - l.get(i))};
        }
        throw new IllegalArgumentException("Error");
    }
}
