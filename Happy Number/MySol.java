class Solution {
    public boolean isHappy(int n) {
        
        Set<Integer> set = new HashSet<>();
        return isHappie(n, set);
    }
    
    public boolean isHappie(int n, Set<Integer> set){
        
        if(n == 1)
            return true;
        if(set.contains(n))
            return false;
        
        set.add(n);
        
        int sum = 0;
        
        while(n>0){
            int rem = n%10;
            sum += rem*rem;
            n = n/10;
        }
        
        return n == 1 ? true : isHappie(sum, set);
    }
    
}

// 9 = 81
// 8 + 1 = 65
// 6 + 5 = 61
// 6 + 1 = 37
// 3 + 7 = 58
// 5 + 8 = 73
// 7 + 3 = 58
// 5 + 8 = 73

 
