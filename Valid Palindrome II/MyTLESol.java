//StringBuilder's reverse method takes O(n) to revrse the string and that's why the overall time complexity becomes O(n^2)

class Solution {
    public boolean validPalindrome(String s) {
        
        StringBuilder str1 = new StringBuilder(s);
        if(s.equals(str1.reverse().toString()))
            return true;
        
        for(int i=0; i<s.length(); i++){
            StringBuilder str = new StringBuilder(s);
            str.deleteCharAt(i);
            // System.out.println("str: " +str);
            StringBuilder reversedstr = new StringBuilder(str.toString());
            // System.out.println("rev: " +reversedstr);
            if(str.toString().equals(reversedstr.reverse().toString())){
                // System.out.println("rev3: " +reversedstr);
                return true;
            }
            
        }
        return false;
    }
}
