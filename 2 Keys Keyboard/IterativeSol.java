// Refer - https://www.youtube.com/watch?v=jGol-NUnjaY

class Solution {
    public int minSteps(int n) {
        
        int curr = 1, count = 0, buffer = 0;
        
        while(curr < n){
            int rest = n - curr;
            
            if(rest % curr == 0){
                buffer = curr;
                curr += buffer;
                count += 2;
            } 
            else{
                curr += buffer;
                count++;
            }
        }
        return count;
    }
}

// n=2
// AA CP

// n=3
// 'AAA' CPP
    
// n=4
// AAAA   CPPP or CPCP

// n=5
// AAAAA  CPPPP 
    
// n=6
// AAAAAA CPPPPP or CPPCP or CPCPP
