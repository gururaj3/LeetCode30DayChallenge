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
    public int kthSmallest(TreeNode root, int k) {
        
        Queue<Integer> q = new PriorityQueue<>(
        (n1, n2) -> n2 - n1);
        
        Queue<TreeNode> tq = new LinkedList<>();
        tq.add(root);
        
        while(!tq.isEmpty()){
            
            TreeNode temp = tq.poll();
            q.add(temp.val);
            if(q.size()>k)
                q.poll();
            
            if(temp.left != null)
                tq.add(temp.left);
            if(temp.right != null)
                tq.add(temp.right);
            
        }
        return q.poll();
        
    }
}
