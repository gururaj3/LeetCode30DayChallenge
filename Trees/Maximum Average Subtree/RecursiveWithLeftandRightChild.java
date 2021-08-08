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
    private double maxAvg = 0;
    
    private double[] helper(TreeNode root){
        if(root == null)
            return new double[]{0, 0};
        
        double[] left = helper(root.left);
        double[] right = helper(root.right);
        double key = left[0] + right[0] + root.val;
        double val = left[1] + right[1] + 1;
        
        maxAvg = Math.max(maxAvg, 1.0 * key / val);
        return new double[]{key, val};
    }
    
    public double maximumAverageSubtree(TreeNode root) {
        helper(root);
        return maxAvg;
    }
}
