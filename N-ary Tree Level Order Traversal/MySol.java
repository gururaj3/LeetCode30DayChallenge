/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        
        List<List<Integer>> ans = new ArrayList<>();
        
        if(root == null)
            return ans;
        
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            
            List<Integer> res = new ArrayList<>();
            int len = q.size();
            
            for(int i=0; i<len; i++){
                Node temp = q.poll();
                List<Node> children = temp.children;
                
                res.add(temp.val);
                
                
                for(int j=0; j<children.size(); j++)
                    q.add(children.get(j));
                
            }
            ans.add(res);
        }
        
        return ans;
    }
}
