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
    
    public class tupl {
        TreeNode r;
        Integer min;
        Integer max;
        
        tupl(TreeNode r, Integer min, Integer max){  
        this.r=r;  
        this.min=min;  
        this.max=max;  
        }  
    }
    
    public boolean isValidBST(TreeNode root) {
        
        Stack<tupl> s = new Stack();
        
        s.push(new tupl(root, null, null));
        
        while(!s.isEmpty()){
            tupl t = s.pop();
            TreeNode r = t.r;
            Integer min = t.min;
            Integer max = t.max;
            
            if((min != null && r.val<=min) || (max != null && r.val>=max))
                return false;
            if(r.left != null)
                s.push(new tupl(r.left, min, r.val));
            if(r.right != null)
                s.push(new tupl(r.right, r.val, max));
            
        }    
            return true;
    }
}
