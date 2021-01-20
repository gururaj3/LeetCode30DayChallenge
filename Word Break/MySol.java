class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        
        boolean dp[] = new boolean[s.length() + 1];
        dp[0] = true;
        
        for(int i=0; i<=s.length(); i++){
            for(int j=0; j<=i; j++){
                if(dp[j] && wordDict.contains(s.substring(j, i))){
                    dp[i] = true;
                }
            }
        }
        return dp[s.length()];  
    }
}

// leetcode
// i=0
// j=0


// i=1
// j=0 j=1
// l   

// i=2
// j=0 j=1 j=2
// le  e  

// i=3
// j=0 j=1 j=2 j=3
// lee ee  e  

// i=4
// j=0  j=1  j=2  j=3 j=4
// leet eet  et   t

// i=5
// j=0    j=1   j=2   j=3 j=4 j=5
// leetc  eetc  etc   tc  c

// i=6
// j=0     j=1    j=2    j=3  j=4 j=5 j=6
// leetco  eetco  etco   tco  co  o

// i=7
// j=0      j=1     j=2     j=3   j=4  j=5  j=6 j=7
// leetcod  eetcod  etcod   tcod  cod  od   d

// i=8
// j=0       j=1      j=2      j=3    j=4   j=5   j=6  j=7 j=8
// leetcode  eetcode  etcode   tcode  code  ode   de   e
