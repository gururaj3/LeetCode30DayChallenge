class Solution {
     public String longestCommonPrefix(String[] strs) {
         
        if (strs == null || strs.length == 0) return "";
         
        for (int i = 0; i < strs[0].length() ; i++){
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j ++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) //if str[0]'s length is small as compared to str[j]'s length  or for eg: ["ab", "a"] then just return str[0]'s substring
                    return strs[0].substring(0, i);             
            }
        }
        return strs[0]; //if all strings equal then return strs[0]
    }
}
