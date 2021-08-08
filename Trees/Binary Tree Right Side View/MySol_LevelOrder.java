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
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> list = new ArrayList<>();
        if(root == null)
            return list;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            
            int len = q.size();
            for(int i=0; i<len; i++){
                
                TreeNode r = q.poll();
                if(i == len-1){
                    list.add(r.val);
                }        
                if(r.left != null)
                    q.add(r.left);
                
                if(r.right != null)
                    q.add(r.right);
                
            }
        }  
        return list;
    }
}
