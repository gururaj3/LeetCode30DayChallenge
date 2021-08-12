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

/*
Solution without initializing (0,1) in the map:
public class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0, currSum = 0;
        HashMap<Integer, Integer> h = new HashMap();
        
        for (int num : nums) {
            // current prefix sum
            currSum += num;
            
            // situation 1:  
            // continuous subarray starts 
            // from the beginning of the array
            if (currSum == k)
                count++;
            
            // situation 2:
            // number of times the curr_sum − k has occured already, 
            // determines the number of times a subarray with sum k 
            // has occured upto the current index
            count += h.getOrDefault(currSum - k, 0);
            
            // add the current sum
            h.put(currSum, h.getOrDefault(currSum, 0) + 1);    
        }
                
        return count;
    }
}
*/
