class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        
        List<String> result = new ArrayList<>();
        int n = words.length;
        int i = 0;
        while(i<n){
            
            int j = i+1;
            int lineLength = words[i].length();
            
            while(j<n && (lineLength+words[j].length()+(j-i-1) < maxWidth)){
                lineLength += words[j].length();
                ++j;
            }
            
            int diff = maxWidth - lineLength;
            int numberOfWords = j - i;
            
            if(numberOfWords == 1 || j>=n)
                result.add(leftJustify(diff, words, i, j));
            else
                result.add(middleJustify(diff, words, i, j));
            
            i = j;
            
        }
        
        return result;
        
    }
    
    private String leftJustify(int diff, String[] words, int i, int j){
        
        int spacesOnRight = diff-(j-i-1);
        
        StringBuilder r = new StringBuilder(words[i]);
        for(int k=i+1; k<j; ++k)
            r.append(" " + words[k]);
        r.append(" ".repeat(spacesOnRight));
        
        return r.toString();
        
    }
    
    private String middleJustify(int diff, String[] words, int i, int j){
        
        int spacesNeeded = j - i - 1;
        int spaces = diff / spacesNeeded;
        int extraSpaces = diff % spacesNeeded;
        
        StringBuilder r = new StringBuilder(words[i]);
        for(int k=i+1; k<j; ++k){
            int spacesToApply = spaces + (extraSpaces-- > 0 ? 1 : 0);
            r.append(" ".repeat(spacesToApply) + words[k]);
        }
        return r.toString();
        
    }
}
