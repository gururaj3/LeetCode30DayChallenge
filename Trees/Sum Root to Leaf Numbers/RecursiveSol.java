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
    int ans = 0;
    public int sumNumbers(TreeNode root) {
        
        preorder(root, 0);
        return ans;
    }
    
    public void preorder(TreeNode root, int curSum){
        
        if(root == null){
            return;
        }
        curSum = root.val + curSum*10;
        if(root.left == null && root.right == null){
            ans += curSum;
            return;
        }

        preorder(root.left, curSum);
        preorder(root.right, curSum);
        
        return;
        
    }
}

/*

*/
