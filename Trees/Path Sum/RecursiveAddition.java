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
    
    public boolean hasPathSum(TreeNode root, int targetSum) {
        
        return helper(root, targetSum, 0);   
    }
    
    public boolean helper(TreeNode root, int targetSum, int curSum){
        if(root == null){
            return false;
        }
        if(root.left == null && root.right == null){
            if(curSum + root.val == targetSum){
                return true;
            }
            else {
                return false;
            }
                
        }
        
        return helper(root.left, targetSum, curSum + root.val) || helper(root.right, targetSum, curSum + root.val);
    }
}


