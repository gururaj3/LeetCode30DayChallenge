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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        
        List<List<Integer>> mainList = new ArrayList<List<Integer>>();
        
        if(root == null)
            return mainList;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        int level = 0;
        
        while(!q.isEmpty()){
            
            mainList.add(new ArrayList());
            int level_length = q.size();
            
            for(int i=0; i<level_length; i++){
                
                TreeNode n = q.poll();
                
                List<Integer> list = mainList.get(level);
                list.add(n.val);
                
                if(n.left != null){
                    q.add(n.left);
                }
                
                if(n.right != null){
                    q.add(n.right);
                }
                
            }
            level++;
            
        }
        Collections.reverse(mainList);
        return mainList;
        
    }
}
