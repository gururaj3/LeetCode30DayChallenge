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
    int min = Integer.MAX_VALUE; 
    public int minDepth(TreeNode root) {
        
        if(root == null)
            return 0;
        if(root.left == null && root.right == null)
            return 1;
        
        return dfs(root, 1);
        
    }
    
    private int dfs(TreeNode root, int depth){
        
        if(root.left == null && root.right == null){
            if(depth < min){
                min = depth;
            }
            return depth -= 1;
        }
        
        if(root.left != null)
            dfs(root.left, depth + 1);
        
        if(root.right != null)
            dfs(root.right, depth + 1);
        
            return min;
        
    }
}
// min = 5
