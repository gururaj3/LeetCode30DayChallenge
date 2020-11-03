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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> mainList = new ArrayList<>();
        
        if (root == null) 
            return mainList;
        
        Queue<TreeNode> q = new LinkedList<>();
        
        q.add(root);
        int level = 0;
        
        while(!q.isEmpty()){
            
            mainList.add(new ArrayList<Integer>());
            int level_length = q.size();
            
            for(int i=0; i<level_length; i++){
                TreeNode r = q.poll();
                mainList.get(level).add(r.val);
                if(r.left!=null){
                    q.add(r.left);

                }

                if(r.right!=null){
                    q.add(r.right);

                }
            }
            level++;
             
            
        }
        return mainList;
    }
}
