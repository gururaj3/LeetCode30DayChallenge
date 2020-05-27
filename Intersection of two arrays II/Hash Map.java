class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        
        if(nums1.length > nums2.length)
            return intersect(nums2, nums1);
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i: nums1)
            map.put(i, map.getOrDefault(i, 0) +1);
        
        int k=0;
        for(int i: nums2){
            int cnt = map.getOrDefault(i, 0);
            if(cnt>0){
                nums1[k++] = i;
                map.put(i, --cnt);
            }
        }
        return Arrays.copyOfRange(nums1, 0, k);
    }
}