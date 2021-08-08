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
class BSTIterator {

    List<Integer> l = new ArrayList<>();
    List<Integer> list;
    int idx = 0;
    public BSTIterator(TreeNode root) {
        this.list = inorder(root);
    }
    
    public int next() {
        return idx<list.size() ? list.get(idx++) : -1;
    }
    
    public boolean hasNext() {
        return idx<list.size() ? true : false;
    }
    
    public List<Integer> inorder(TreeNode root){
        
        if(root == null)
            return l;
        inorder(root.left);
        l.add(root.val);
        inorder(root.right);
        
        return l;
        
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */

// left root right

// 3,7,9,15,20
