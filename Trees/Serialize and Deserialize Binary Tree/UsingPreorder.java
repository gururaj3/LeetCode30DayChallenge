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
    int idx=0;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        
        if(root == null)
            return "null,";
        
        String str = root.val+","+serialize(root.left)+serialize(root.right);
        return str;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
        data = data.substring(0, data.length()-1);
        String[] preorder = data.split(",");

        return helper(preorder);

    }
    
    public TreeNode helper(String[] preorder){
        if(idx == preorder.length)
            return null;
        if(preorder[idx].equals("null")){
            idx++;return null;
        }

        String val = preorder[idx];
        TreeNode root = new TreeNode(Integer.valueOf(val));
        idx++;
        
        root.left = helper(preorder);
        root.right = helper(preorder);
        
        return root;
        
    }
}

/*              
1,2,null,null,3,4,null,null,5,null,null,
           0 1  2    3   4 5  6    7   8  9    10
preorder = 1 2 null null 3 4 null null 5 null null

                                      h(p)
                                    idx=0,r=1
                          
                    h(p)                                  h(p)       
                 idx=1,r=2                              idx=4,r=3         
        
        h(p)            h(p)                    h(p)                h(p)
    idx=2,r N       idx=3, rN                 idx=5,r=4             idx=8,r=5
                r 2                     
                                            h(p)        h(p)       h(p)         h(p)
                                            idx=6,r N idx=7,r N   idx=9,r N    idx=10, r N
                                                
                                                r 4                     r 5
                
                                    r 1
*/



// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
