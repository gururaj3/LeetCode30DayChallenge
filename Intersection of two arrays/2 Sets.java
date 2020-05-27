class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        
        for(int i : nums1)
            set1.add(i);
        for(int i : nums2)
            set2.add(i);
        
        if(set1.size()<set2.size())
            return set_intersection(set1, set2);
        else
            return set_intersection(set2, set1);
        
        
        
    }
    public int[] set_intersection(Set<Integer> set1, Set<Integer> set2){
            int output[] = new int[set1.size()];
            int j=0;
            for(int i: set1)
                if(set2.contains(i))
                    output[j++] = i;
            
            return Arrays.copyOf(output, j);
        }
}