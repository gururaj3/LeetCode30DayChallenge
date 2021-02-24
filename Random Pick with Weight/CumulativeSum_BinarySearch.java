class Solution {
    
    int sum = 0;
    int[] w;
    public Solution(int[] w) {
        this.w = w;
        for(int i=0; i<w.length; i++){
            sum += w[i];
            w[i] = sum;
        }
            
    }
    
    public int pickIndex() {
        
        double target = sum * Math.random();
        
        if(w.length == 1)
            return 0;
        
        int left = 0, right = w.length-1;
        
        while(left <= right){
            
            int mid = left+(right-left)/2;
            
            if(w[mid] < target)
                left = mid+1;
            else
                right = mid-1;
            
        }
        return left;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
