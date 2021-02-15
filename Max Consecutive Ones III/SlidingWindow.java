class Solution {
    public int longestOnes(int[] A, int K) {
        
        int left = 0, right = 0;
        int numZeroes = 0, longestSeq = 0;
        
        while(right < A.length){
            
            if(A[right] == 0){
                numZeroes++;
            }
            
            while(numZeroes == K+1){
                if(A[left] == 0){
                    numZeroes--;
                }
                left++;
            }
            
            longestSeq = Math.max(longestSeq, right - left + 1);
            right++;
        }
        return longestSeq;
    }
}
