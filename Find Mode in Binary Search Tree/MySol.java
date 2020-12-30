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
    public int[] findMode(TreeNode root) {
        
        if(root == null)
            return new int[0];
        
        Map<Integer, Integer> map = new LinkedHashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            
            TreeNode r = q.poll();
            map.put(r.val, map.getOrDefault(r.val, 0) + 1);
            
            if(r.left != null)
                q.add(r.left);
            if(r.right != null)
                q.add(r.right);
            
        }
        
        int max = Integer.MIN_VALUE;
        
        for(int i : map.keySet()){
            if(map.get(i)>max)
                max = map.get(i);
            // if(map.get(i) == max)
        }
        
        
        List<Integer> list = new ArrayList<>();
        
        for(int i : map.keySet()){
            if(map.get(i)>=max)
                list.add(i);
            // if(map.get(i) == max)
        }
        
        int[] arr = new int[list.size()];
        for(int i=0; i<list.size(); i++)
            arr[i] = list.get(i);
        
        return arr;
        
        
        
    }
}
