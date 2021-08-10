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
    int[] preorder;
    int[] postorder;
    Map<Integer, Integer> postorderMap;
    
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        this.postorder = postorder;
        this.preorder = preorder;
        this.postorderMap = new HashMap<>();
        
        int i=0;
        for(int num : postorder)
            postorderMap.put(num, i++);
        
        return constructBST(0, preorder.length-1, 0, postorder.length-1);
    }
    
    public TreeNode constructBST(int preorderStart, int preorderEnd, int postorderStart, int postorderEnd){
        // System.out.println("preS: "+preorderStart+" preE: "+preorderEnd+" postS: "+postorderStart+" postE: "+postorderEnd);
        if(preorderStart > preorderEnd)//base case when we rech to wrong index, retuning null to tell the parent there is no node 
            return null;
        
        int val = preorder[preorderStart];
        TreeNode root = new TreeNode(val);
        
        if(preorderStart == preorderEnd)//when we reach to array size of 1, we return that node since no child is present after that node 
            return root;

        int leftRootIndex = postorderMap.get(preorder[preorderStart + 1]);
        int leftSubtreeSize = leftRootIndex - postorderStart + 1;
   
        root.left = constructBST(preorderStart+1, preorderStart + leftSubtreeSize, postorderStart, leftRootIndex);
        root.right = constructBST(preorderStart + leftSubtreeSize + 1, preorderEnd, leftRootIndex + 1, preorderEnd);
        return root;
        
    }
    
}

/*

                                                BST(0,6,0,6)
                                                r=1, lI=2, lS=3

                r.l = BST(1,3,0,2)                                  r.r = BST(4,6,3,6)
                      r=2,lI=0,lS=1                                       r=3,lI=3,lS=1

    r.l = BST(2,2,0,0)         r.r = BST(3,3,1,3)              r.l = BST(5,5,3,3)       r.r = BST(6,6,4,6)
          r=4                        r=5                             r=6                      r=7
          return 4;                  return 5;                       return 6;                return 7;

                    return 2;                                               return 3;
                                                   return 1;
                                                


preorder = [1,2,4,5,3,6,7]  Root-Left-Right
postorder = [4,5,2,6,7,3,1] Left-Right-Root

4->0
5->1
2->2
6->3
7->4
3->5
1->6
                                    

*/
