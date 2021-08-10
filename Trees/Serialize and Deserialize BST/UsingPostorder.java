/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    int[] postorder;
    int idx;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        
        if(root == null)
            return "";
        
        String str = serialize(root.left) + serialize(root.right) + root.val + " ";
        
        return str;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.isEmpty())
            return null;
        
        this.postorder = new int[data.length()/2];
        int j=0;
        for (String s : data.split("\\s+")){
            postorder[j++] = Integer.valueOf(s);
        }
            
        postorder = Arrays.copyOf(postorder, j);
        this.idx = postorder.length-1;
        
        return helper(Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    public TreeNode helper(int min, int max){
        // System.out.println("min: "+min+" max: "+max);
        if(idx < 0)
            return null;
        
        int val = postorder[idx];
        TreeNode root = new TreeNode(val);
        
        if(val < min || val > max)
            return null;
        idx--;
        
        root.right = helper(val, max);
        root.left = helper(min, val);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;
