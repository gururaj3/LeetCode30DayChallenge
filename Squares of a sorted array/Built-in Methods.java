class Solution {
    public int[] sortedSquares(int[] A) {
        
        int index = 0;
        
        for(int i : A)
            A[index++] = i*i;
        
        Arrays.sort(A);
        
        return A;
        
    }
}