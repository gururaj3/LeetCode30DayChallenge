class Solution {
    public int countPrimes(int n) {
        
        if(n == 0 || n == 1)
            return 0;
        int count = 0;
        for(int i=2; i<n; i++){
            
            boolean flag = false;
            for(int j=2; j*j<=i; j++){
                
                if(i%j == 0){
                    flag = true;
                    break;
                }
                    
            }
            if(!flag)
                count++;
        }
        return count;
    }
}
