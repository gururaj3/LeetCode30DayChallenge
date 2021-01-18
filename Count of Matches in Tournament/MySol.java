class Solution {
    
    List<Integer> list = new ArrayList<>();
    int sum = 0;
    public int numberOfMatches(int n) {
        
        if(n == 1)
            return 0;
        
        if(n == 2){
            list.add(1);
            for(int i: list)
                sum += i;
            return sum;
        }
            
        if(n%2 == 0){
            list.add(n/2);
            numberOfMatches(n/2);
        }
        else{
            list.add((n-1)/2);
            numberOfMatches((n-1)/2 + 1);
        }
        return sum;
    }
}

// numberOfMatches(7)
// numberOfMatches(4)
// numberOfMatches(2)
