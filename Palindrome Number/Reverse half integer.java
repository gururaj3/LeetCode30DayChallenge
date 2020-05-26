class Solution {
    public boolean isPalindrome(int x) {
        
        if(x<0 || (x%10 == 0 && x!=0))
            return false;
        
        int rN = 0;
        while(x>rN){
            rN = rN*10 + x%10;
            x /= 10;
        }
        
        if( x==rN || x==rN/10)
            return true;
        return false;
    }
}