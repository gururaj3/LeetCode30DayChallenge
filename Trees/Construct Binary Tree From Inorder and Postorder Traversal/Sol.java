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
    
    int[] inorder;
    int[] postorder;
    Map<Integer, Integer> map;
    int idx;
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        this.postorder = postorder;
        this.inorder = inorder;
        this.map = new HashMap<>();
        this.idx = postorder.length-1;
        
        int i=0;
        for(int num : inorder)
            map.put(num, i++);
        
        return buildTreeHelper(0, inorder.length);
    
    }
    
    public TreeNode buildTreeHelper(int in_left, int in_right){
        
        if(in_left>=in_right)
            return null;
        
        int val = postorder[idx];
        TreeNode root = new TreeNode(val);
        idx--;
        
        root.right = buildTreeHelper(map.get(val)+1, in_right);
        root.left = buildTreeHelper(in_left, map.get(val));
        
        return root;
        
    }
    
}

/*
postorder -> [9,15,7,20,3]  Left-Right-Root
inorder -> [9,3,15,20,7]    Left-Root-Right
preorder -> [3,9,20,15,7]   Root-Left-Right

9->0
3->1
15->2
20->3
7->4


*/
