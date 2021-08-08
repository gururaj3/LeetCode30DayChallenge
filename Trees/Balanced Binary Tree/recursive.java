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
    public boolean isBalanced(TreeNode root) {

        return dfs(root)==-1 ? false : true ;

    }
    
    public int dfs(TreeNode root){
        
        if(root == null)
            return 0;
            
        int l = dfs(root.left);
        int r = dfs(root.right);
        
        if(l == -1 || r == -1 || Math.abs(l-r) > 1)
            return -1;
            
        return Math.max(l,r)+1;
        
    }
}
