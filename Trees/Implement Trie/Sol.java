Refer - https://www.youtube.com/watch?v=giiaIofn31A&t=107s

class Trie {

    private Node root;
    /** Initialize your data structure here. */
    public Trie() {
        this.root = new Node('\0');
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node curr = root;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            
            if(curr.children[ch-'a'] == null){
                curr.children[ch-'a'] = new Node(ch); 
            }
            curr = curr.children[ch-'a'];
        }
        curr.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node curr = root;
        
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            
            if(curr.children[ch-'a'] == null){
                return false;
            }
            curr = curr.children[ch-'a'];
        }
        return curr.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        
        Node curr = root;
        for(int i=0; i<prefix.length(); i++){
            char ch = prefix.charAt(i);
            
            if(curr.children[ch-'a'] == null){
                return false;
            }
            curr = curr.children[ch-'a'];
        }
        return true;
    }
    
    public class Node{
        char c;
        Node[] children;
        boolean isWord;
        
        Node(char c){
            this.c = c;
            children = new Node[26];
            isWord = false;
        }
        
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
