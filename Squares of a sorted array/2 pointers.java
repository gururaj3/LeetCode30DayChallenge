class Solution {
    public int[] sortedSquares(int[] A) {
        
        int len = A.length;
        int i=0, j=0;
        
        while(j<len && A[j]<0)
            j++;
        
        j = j-1;
        i = j+1;
        
        int[] output = new int[len];
        int t = 0;
        
        while(i<len && j>=0){
            if(A[j]*A[j] > A[i]*A[i]){
                output[t++] = A[i]*A[i];
                i++;
            }
            else{
                output[t++] = A[j]*A[j];
                j--;
            }
        }
        
        while(j>=0){
            output[t++] = A[j]*A[j];
            j--;
        }
        while(i<len){
            output[t++] = A[i]*A[i];
            i++;
        }
        
        return output;
    }
}