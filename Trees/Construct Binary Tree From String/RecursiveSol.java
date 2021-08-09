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
    
    // treat the string as a queue where the index points to the current head 
    // of the queue. As we create TreeNodes, we remove from the head of the queue
    // by incrementing this index.
    private int index = 0;
    
    public TreeNode str2tree(String s) {
        
        // no string, no tree.
        if(index == s.length())
            return null;
        
        //get node value
        int val = getNum(s);
        
        // create the current node with the final number.
        TreeNode current = new TreeNode(val);
        
        // check if the next element in the string is '('. That indicates the current
        // node has a left child. Make sure to increment the index. If the next element is
        // ')' we are done with this node and can return it (after incrementing the index).
        if(index < s.length()){
            
            if(s.charAt(index) == '('){
                index++;
                current.left = str2tree(s);
            }else{
                index++;
                return current;
            }
        }
        
        // perform the same check again if the next element is '(' we must create a right 
        // child of the current node.
        if(index < s.length()){

            if(s.charAt(index) == '('){
                index++;
                current.right = str2tree(s);
            }else{
                index++;
                return current;
            }
        }
        
        // in cases of multiple levels of children, make sure to increment the 
        // index on ')' so that future nodes are handled on their proper scope.
        // e.g 4(2(3)(1))(6(5)) OR 1(2(3)(4))(5)  
        if(index < s.length() && s.charAt(index) == ')')
            index++;
        
        return current;
    }
    
    public int getNum(String s){
        // check if the current node value is negative or not.
        
        int ans = 0;
        boolean isNegative = false;
        if(s.charAt(index) == '-'){ 
            isNegative = true; index++;
        }
        while( index < s.length() && Character.isDigit(s.charAt(index)) ){
            ans = ans * 10 + ( s.charAt(index++) - '0');
        }
        return isNegative ? ans * -1 : ans;
    }
}
