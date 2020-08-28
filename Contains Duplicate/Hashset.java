class Solution {
    public boolean containsDuplicate(int[] nums) {
        
        Set<Integer> s = new HashSet<Integer>();
        boolean b;
        
        for(int i : nums){
            b = s.add(i);
            if(b == false)
                return true;
        }
        return false;
    }
}
