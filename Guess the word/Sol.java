/**
 * // This is the Master's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface Master {
 *     public int guess(String word) {}
 * }
 */
/**
 * // This is the Master's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface Master {
 *     public int guess(String word) {}
 * }
 */
class Solution {
    public void findSecretWord(String[] wordlist, Master master) {
        
        Random ran = new Random();
        
        ArrayList<String> possibles = new ArrayList<>();
        for (String word : wordlist){
            possibles.add(word);
        }
        
        int trials = 0;
        while (trials < 10){
            int index = ran.nextInt(possibles.size());
            // System.out.println("idx: "+index);
            String testWord = possibles.get(index);
            // System.out.println("testWord: "+testWord);
            int matches = master.guess(testWord);
            if (matches == 6)
                return;
            ArrayList<String> newPossibles = new ArrayList<>();
            for (String word : possibles){
                if (countMatches(testWord, word) == matches){
                    newPossibles.add(word);
                }
            }
            // System.out.println("newPossibles: "+newPossibles);
            possibles = newPossibles;
            trials++;
        }
    }
    
    private int countMatches(String word1, String word2){
        int m = 0;
        for (int i = 0; i < 6; ++i){
            if (word1.charAt(i) == word2.charAt(i)){
                m++;
            }
        }
        return m;
    }
}

/*


*/
