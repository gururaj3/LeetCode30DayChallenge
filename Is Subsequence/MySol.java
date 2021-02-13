class Solution {
    public boolean isSubsequence(String s, String t) {
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
