class Solution {
    public int[] countBits(int num) {
        
        int[] result = new int[num+1];
        result[0] = 0;
        
        for(int i=1; i<=num; i++){
            int pos = i;
            int c = 0; 
            while(pos>0){
                c += pos&1;
                pos >>= 1;
            }
            result[i] = c;
        }
        
        return result;
        
    }
}
