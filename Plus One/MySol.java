class Solution {
    public int[] plusOne(int[] digits) {
        
        int n = digits.length-1;
        int res[] = new int[n+2];
        
        while(n>=0 && digits[n] == 9){
            res[n+1] = 0;
            n--;
        }
        if(n !=-1 ){
            res[n+1] = digits[n] + 1;
            n--;
        }
            
        else{
            res[0] = 1;
            return res;
        }
            
        while(n>=0){
            res[n+1] = digits[n];
            n--;
        }
        return Arrays.copyOfRange(res, 1, res.length);
    }
}
