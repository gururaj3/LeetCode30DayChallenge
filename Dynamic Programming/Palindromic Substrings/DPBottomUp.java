class Solution {
    public int countSubstrings(String s) {
    
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int res = 0;
        for(int i = len-1; i > -1; i--){
            for(int j = i; j < len; j++){
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j-i <= 2 || dp[i+1][j-1]);
                    if(dp[i][j]){res++;}
            }
        }
        return res;
    }
}
