class Solution {
    
    // List<Integer> list = new ArrayList<>();
    int res = 0;
    public int numberOfMatches(int n) {
        
        if(n == 1)
            return 0;
        
        backtrack(n, 1);
        return res;
    }
    
    public void backtrack(int n, int sum){
        
        if(n == 2){
            res = sum;
            return;
        }
        
        if(n%2 == 0)
            backtrack((n/2), sum + n/2);
        else{
            backtrack((n-1)/2 + 1, sum + (n-1)/2);
        }
        
    }
}

// numberOfMatches(7)
// numberOfMatches(4)
// numberOfMatches(2)
