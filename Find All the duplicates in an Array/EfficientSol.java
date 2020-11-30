class Solution {
    public List<Integer> findDuplicates(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            int newIndex = Math.abs(nums[i]) - 1;
            nums[newIndex] *= -1;
        }

        List<Integer> result = new LinkedList<Integer>();

        for (int num : nums) {
            if (nums[Math.abs(num) - 1] > 0) {
                result.add(Math.abs(num));
                nums[Math.abs(num) - 1] *= -1;
            }
        }
        
        return result;
        
    }
}
