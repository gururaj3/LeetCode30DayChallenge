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
    
    int idx = 0;
    int[] preorder;
    int[] inorder;
    Map<Integer, Integer> map;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        this.preorder = preorder;
        this.inorder = inorder;
        this.map = new HashMap<>();
        int i=0;
        for(int num : inorder)
            map.put(num, i++);

        return helper(0, preorder.length);
    }
    
    public TreeNode helper(int in_left, int in_right){

        if(in_left == in_right)
            return null;
        
        int val = preorder[idx];
        TreeNode root = new TreeNode(val);
        
        idx++;
        root.left = helper(in_left, map.get(val));
        root.right = helper(map.get(val)+1, in_right);
        return root;
    }
    
}
