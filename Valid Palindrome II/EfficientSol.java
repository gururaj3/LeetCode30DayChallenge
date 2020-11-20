class Solution {
    
    public boolean validPalindrome(String s) {
        
        for(int i=0; i<s.length()/2; i++){
            if(s.charAt(i) != s.charAt(s.length()-1-i)){
                return isPalindrome(s, i, s.length()-1-i-1) || isPalindrome(s, i+1, s.length()-1-i);
            }
        }
        return true;
    }
    
    private boolean isPalindrome(String s, int start, int end){
        int len = (start+end+1);
        for(int i=start; i<len/2; i++){
            if(s.charAt(i) != s.charAt(len-1-i)){
                return false;
            }
        }
        return true;
    }
    
}
