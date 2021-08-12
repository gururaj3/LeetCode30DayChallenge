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
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        
        // List<Integer> list = new ArrayList<>();
        return helper(root, targetSum, new ArrayList<>());
        
        // return ans;
        
    }
    
    public List<List<Integer>> helper(TreeNode root, int targetSum, List<Integer> list){
        // System.out.println("val: "+root.val+" sum: "+targetSum+" list: "+list);
        if(root == null)
            return ans;
        
        if(root.left == null && root.right == null){
            if(targetSum - root.val == 0){
                list.add(root.val);
                // System.out.println("val: "+root.val+" sum: "+targetSum+" list: "+list);
                ans.add(new ArrayList<>(list));
                list.remove(list.size()-1);
                return ans;
            }
            else
                return ans;
        }
        list.add(root.val);
        helper(root.left, targetSum-root.val, list);
        helper(root.right, targetSum-root.val, list);
        list.remove(list.size()-1);
        return ans;
    }
}

/*

Check if curr node is leaf
    if yes, then check if targetSum == sum we calculate

*/
