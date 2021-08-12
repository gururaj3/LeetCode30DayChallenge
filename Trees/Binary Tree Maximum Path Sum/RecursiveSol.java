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
  int max_sum = Integer.MIN_VALUE;

  public int max_gain(TreeNode node) {
    if (node == null) 
        return 0;

    // max sum on the left and right sub-trees of node
    int left_gain = Math.max(max_gain(node.left),0);
    int right_gain = Math.max(max_gain(node.right),0);

    // the price to start a new path where `node` is a highest node
    int price_newpath = node.val + left_gain + right_gain;  //Simulates case 2

    // update max_sum if it's better to start a new path
    max_sum = Math.max(max_sum, price_newpath);    //Simulates case 3 and case 2

    // for recursion :
    // return the max gain if continue the same path
    return node.val + Math.max(left_gain, right_gain);  //Simulates case 1
  }

  public int maxPathSum(TreeNode root) {
    max_gain(root);
    return max_sum;
  }
}

/*

Cases:
Case 1: Current Node is in the path of Max Sum
Case 2: Current Node is root of the Max Sum
Case 3: Current Node is not in path of Max Sum

Why we need to do:Math.max(max_gain(node.left),0); and Math.max(max_gain(node.right),0);
Consider tree [7,-2,2]
We don't want to add -2 to our path which will result in 7 while correct ans will be 9 and that's why we compare it with 0.

                           mg(7)
                    
        lg=mg(-2)                       rg=mg(2)
        
    
lg=mg(N)        rg=mg(N)            lg=mg(N)        rg=mg(N)
r 0               r 0                 r 0               r 0
        pnp=-2+0+0                          pnp=2+0+0
        ms=(-2,-inf)                        ms=(-2,2)
        r -2+0=-2                           r 2+0=2
                        pnp=7-2+2
                        ms=(2,7)
                        r 9

*/
