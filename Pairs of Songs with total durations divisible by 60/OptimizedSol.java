//Refer https://www.youtube.com/watch?v=wxqN1HX4Djk

class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        
        int[] rem = new int[60];
        int pairs = 0;
        
        for(int t : time)
            rem[t%60]++;
        
        for(int i=1; i<30; i++){
            pairs += rem[i] * rem[60-i];
        }
        
        // System.out.println(rem[0]);
        // System.out.println(rem[30]);
        
        pairs += (rem[0]-1) * (rem[0])/2 ;
        pairs += (rem[30]-1) * (rem[30])/2;
        
        // pairs += sumofN(rem[0]-1) + sumofN(rem[30]-1);
        
        return pairs;
        
    }
    
    
    // public int sumofN(int n){
    //     return n*(n+1)/2;
    // }
}
