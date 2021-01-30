class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) 
            return "";
        
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);  //racecar
            int len2 = expandAroundCenter(s, i, i + 1);   //aabbaa
            int len = Math.max(len1, len2);
            
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
    return s.substring(start, end + 1);
}

private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
}

// There could be 2 conditions for substring - racecar which starts from the same middle index and for aabbaa there is 2 middle indices
