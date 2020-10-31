class Solution {
    
    int[] arr;
    Integer[] intArray;
    int[] nums;
    public Solution(int[] nums) {
        
        arr = nums.clone();
        this.nums = nums.clone();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        
        arr = nums.clone();
        return arr;
        
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        
        Random rand = new Random();
		
		for (int i = 0; i < arr.length; i++) {
			int randomIndexToSwap = rand.nextInt(arr.length);
			int temp = arr[randomIndexToSwap];
			arr[randomIndexToSwap] = arr[i];
			arr[i] = temp;
		}
        return arr;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
