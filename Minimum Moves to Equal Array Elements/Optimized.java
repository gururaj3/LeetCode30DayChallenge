public class Solution {
    public int minMoves(int[] nums) {
        
        int moves = 0, min = Integer.MAX_VALUE;
        
        for (int i = 0; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
        }
        
        for (int i = 0; i < nums.length; i++) {
            moves += nums[i] - min;
        }
        
        return moves;
    }
}

/*

This approach is based on the idea that adding 1 to all the elements except one is equivalent to decrementing 1 from a single element, since we are interested in the relative levels of the elements which need to be equalized.

[1,2,3]

[2,3,4] -> [2,3,3]  decrement 1 at idx 2

[3,4,4] -> [3,4,3]  decrement 1 at idx 2

[4,5,4] -> [4,4,4]  decrement 1 at idx 1
    
    
*/
