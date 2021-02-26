public class Solution {
    public int subarraySum(int[] nums, int k) {
        
        int count = 0, sum = 0;
        Map <Integer, Integer> map = new HashMap < > ();
        map.put(0, 1);
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k))
                count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        
        return count;
    }
}
Time Complexity - O(n)

/*
Prefix Sum = [3,7,14,16,13,14,18,20,21]
Array = [3,4,7,2,-3,1,4,2,1]
Sub arrays = [3,4][7][7,2,-3,1],[1,4,2][2,-3,1,4,2,1][4,2,1]
*/
