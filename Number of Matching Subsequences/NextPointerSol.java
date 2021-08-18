class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        
        ArrayList<Node>[] heads = new ArrayList[26];
        for(int i=0; i< 26; i++)
            heads[i] = new ArrayList<>();
        
        for(String str : words){
            heads[str.charAt(0) - 'a'].add(new Node(str, 0));
        }
        
        int ans = 0;
        
        for(char c : s.toCharArray()){
            
            ArrayList<Node> list = heads[c - 'a'];
            heads[c - 'a'] = new ArrayList<Node>();
            
            for(Node node : list){
                node.idx++;
                if(node.idx == node.word.length())
                    ans++;
                else
                    heads[node.word.charAt(node.idx)-'a'].add(node);
            }
            list.clear();
            
        }
        return ans;
    }
    
    class Node{
        String word;
        int idx;
        Node(String w, int i){
            word = w;
            idx = i;
        }
    }
}

/*

heads
0->[["a",0],["acd",0],["ace",0]]
1->[["bb",0]]
2->[[]]
3->[[]]
4->[[]]
...
25->[[]]


heads
0->[["a",0],["acd",0],["ace",0]]
1->[["bb",0]]
2->[["acd",1],["ace",1]]
3->[[]]
4->[[]]
...
25->[[]]
*/
