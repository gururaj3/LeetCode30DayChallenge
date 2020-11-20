class Solution {
    public String removeDuplicates(String S) {

        StringBuilder res = new StringBuilder();
        int len = 0;
        
        for(char c : S.toCharArray()){
            if(len>=1 && c == res.charAt(res.length()-1)){
                res.deleteCharAt(len - 1);
                len--;
            }
            else{
                res.append(c);
                len++;
            }
        }
        return res.toString();
        
    }
}
