class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        List<Integer> list = new ArrayList<>();
        
        for(int i : nums)
            list.add(i);
        
        if(list.contains(target)){
            int i = list.indexOf(target);
            int j = list.lastIndexOf(target);
            return new int[] {i, j};
        }
        return new int[] {-1, -1};
        
    }
}