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
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(
        (n1, n2) -> Math.abs(n1 - target) > Math.abs(n2 - target) ? -1 : 1);

        List<Integer> ans = new ArrayList<>();
        int min = root.val;
        
        while(!q.isEmpty()){
            
            TreeNode r = q.poll();

            heap.add(r.val);
            if(heap.size()>k)
                heap.poll();

            if(r.left != null)
                q.add(r.left);
            if(r.right != null)
                q.add(r.right);
            
        }
        for(int i : heap)
            ans.add(i);
        return ans;
        
    }
}
