class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        
        Map<Character, Integer> map = new HashMap<>();
        
        int left = 0, right = 0, n = s.length(), max = 0;
        
        while(right < n){
            
            map.put(s.charAt(right), right++);
            
            if(map.size() == k+1){
                int del_idx = Collections.min(map.values());
                map.remove(s.charAt(del_idx));
                left = del_idx+1;
            }
            
            max = Math.max(max, right - left);
            
        }
        return max;
    }
}
