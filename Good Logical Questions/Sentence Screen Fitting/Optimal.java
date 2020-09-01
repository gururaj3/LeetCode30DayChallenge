class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        String sen = String.join(" ", sentence) + " ";
        int i=0; int len = sen.length();
        
        for(int row = 0; row<rows; row++) {
            i += cols;
            while(i>-1 && sen.charAt(i%len) != ' ') {
                i--;
            }
            i++; //For accomodating space
        }
        
        return i/len;
    }
}
