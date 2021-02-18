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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        
        List<TreeNode> ans = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        
        dfs(root, ans, map);
        return ans;
        
    }
    
    public String dfs(TreeNode node, List<TreeNode> ans, Map<String, Integer> map){
        
        if(node == null){
            return "#";
        }   
        String s = node.val + "*" + dfs(node.left, ans, map) + "*" + dfs(node.right, ans, map);
        map.put(s, map.getOrDefault(s, 0) + 1);
        if(map.get(s) == 2)
            ans.add(node);
        return s;
        
    }
}

// Time Compexity - O(n^2)

// We visit each node once and String creation may take O(n) time because we are going to compute the same string twice or more for another dfs. 
