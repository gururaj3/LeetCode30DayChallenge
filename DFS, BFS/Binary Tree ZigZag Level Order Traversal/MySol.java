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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>> mainList = new ArrayList<>();
        
        if(root == null)
            return mainList;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level = 0;
        
        while(!q.isEmpty()){

            mainList.add(new ArrayList<Integer>());
            int level_length = q.size();
            
            for(int i=0; i<level_length; i++){
                
                TreeNode n = q.poll();
                mainList.get(level).add(n.val);

                if(n.left != null)
                    q.add(n.left);
                if(n.right != null)
                    q.add(n.right);
            }
            if(level%2 != 0)
                Collections.reverse(mainList.get(level));
            level++;
        }
        
        
        return mainList;
        
        
    }
}
