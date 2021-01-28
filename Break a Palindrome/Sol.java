class Solution {
    public  String breakPalindrome(String s) {

         int i = 0;
         int j = s.length() - 1;
         String res = "";

         char[] chars = s.toCharArray();

         while(i < j){

             // Find a character which is not 'a'. Once found replace it with 'a'
             if(chars[i] != 'a'){
                 chars[i] = 'a';
                 return new String(chars);
             }
             i++;
             j--;
         }
          // If given string contains only 'a' and string length is more than 1
            //For example "aa" then replace last character with 'b'

         if(res.length() == 0 && s.length() > 1){
             chars[s.length() - 1] = 'b';
             return new String(chars);
         }


            return "";
        }

}
    
