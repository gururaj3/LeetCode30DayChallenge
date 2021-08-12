/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    int prefixSum = 0, count = 0;
    int targetSum;
    Map<Integer, Integer> map;
    
    public int pathSum(TreeNode root, int targetSum) {
        
        this.map = new HashMap<>();
        this.targetSum = targetSum;
        map.put(0, 1);
        
        preorder(root, 0);
        
        return count;
    }
    
    public void preorder(TreeNode root, int prefixSum){
        
        if(root == null)
            return;
        
        prefixSum += root.val;
        
        if(map.containsKey(prefixSum - targetSum))
            count += map.get(prefixSum - targetSum);
        
        map.put(prefixSum, map.getOrDefault(prefixSum, 0)+1);
        preorder(root.left, prefixSum);
        preorder(root.right, prefixSum);
        map.put(prefixSum, map.get(prefixSum) - 1);
        
    }
}
