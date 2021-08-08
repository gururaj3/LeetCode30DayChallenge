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
    public int closestValue(TreeNode root, double target) {
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        int min = root.val;
        
        while(!q.isEmpty()){
            
            TreeNode r = q.poll();
            
            if(Math.abs(r.val - target) < Math.abs(min - target))
                min = r.val;
            
            if(target<r.val){
                if(r.left!=null)
                    q.add(r.left);
            }
            else
                if(r.right!=null)
                    q.add(r.right);      
        }   
        return min; 
    }
}
