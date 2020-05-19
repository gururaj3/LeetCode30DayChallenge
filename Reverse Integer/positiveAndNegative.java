class Solution {
    public int reverse(int x) {
        
        int temp = 0;
        while(x!=0){
            
            temp = x%10 + temp*10;
            x = x/10;
        }
        
        if(x<0)
            return -temp;
        else
            return temp;
        
    }
}