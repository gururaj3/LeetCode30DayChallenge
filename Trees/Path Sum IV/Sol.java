class Solution {
    int ans = 0;
    public int pathSum(int[] nums) {
        
        //Create root node with nums[0] units place value
        Node root = new Node(nums[0] % 10);
        
        
        for (int num: nums) {
            
            //Root node already processed above, so skip
            if (num == nums[0]) 
                continue;
            
            int depth = num / 100, pos = num / 10 % 10, val = num % 10;
            // System.out.println("depth: "+depth+" pos: "+pos+" val: "+val);
            pos--;
            
            Node cur = root;
            for (int d = depth - 2; d >= 0; --d) {
                // System.out.println("d: "+d+" pos: "+pos);
                if (pos < 1<<d) {
                    // System.out.println("l: "+ (1<<d));
                    if (cur.left == null){
                        // System.out.println("New Left Node");
                        cur.left = new Node(val);
                    }
                        
                    cur = cur.left;
                } else {
                    // System.out.println("r: "+ (1<<d));
                    if (cur.right == null) {
                        // System.out.println("New Right Node");
                        cur.right = new Node(val);
                    }
                        
                    cur = cur.right;
                }
                pos %= 1<<d;
            }
        }
        
        dfs(root, 0);
        return ans;
    }

    public void dfs(Node node, int sum) {
        if (node == null) return;
        sum += node.val;
        if (node.left == null && node.right == null) {
            ans += sum;
        } else {
            dfs(node.left, sum);
            dfs(node.right, sum);
        }
    }
}

class Node {
    Node left, right;
    int val;
    Node(int v) {val = v;}
}


/*
Input: 
[110,218,315,326,423,433]

Output to understand better:

depth: 2 pos: 1 val: 8
d: 0 pos: 0
l: 1
New Left Node
depth: 3 pos: 1 val: 5
d: 1 pos: 0
l: 2
d: 0 pos: 0
l: 1
New Left Node
depth: 3 pos: 2 val: 6
d: 1 pos: 1
l: 2
d: 0 pos: 1
r: 1
New Right Node
depth: 4 pos: 2 val: 3
d: 2 pos: 1
l: 4
d: 1 pos: 1
l: 2
d: 0 pos: 1
r: 1
New Right Node
depth: 4 pos: 3 val: 3
d: 2 pos: 2
l: 4
d: 1 pos: 2
r: 2
d: 0 pos: 0
l: 1
New Left Node

*/
