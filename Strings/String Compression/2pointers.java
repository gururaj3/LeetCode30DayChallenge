class Solution {
    public int compress(char[] chars) {
        
        int c = 1;
        int pos = 0;
        
        
        for(int i=1; i<chars.length+1; i++){
            if(i<chars.length && chars[i-1] == chars[i]){
                c++;
            }
            else{
                chars[pos++] = chars[i-1];
                if(c >= 2){
                    for(char a: Integer.toString(c).toCharArray())
                        chars[pos++] = a;
                    c = 1;
                }
            }
        }
        return pos;
    }
}
