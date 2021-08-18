class Solution {
    public int numMatchingSubseq(String S, String[] words) {
        
        int ans = 0;
        for(int k=0; k<words.length; k++){
            if(check(words[k], S))
                ans++;
        }
        
        return ans;
            
        
    }
    
    public boolean check(String s, String t){
        int c = 0;
        for(int i=0; i<s.length(); i++){
            boolean f = false;
            for(int j=c; j<t.length(); j++){
                if(s.charAt(i) == t.charAt(j)){
                    c = j+1;
                    f = true;
                    break;
                }
                
            }
            if(!f)
                return false;
        }
        return true;
    }
}
