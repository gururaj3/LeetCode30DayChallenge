class Solution {
    public boolean areSentencesSimilar(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        
        if(sentence1.length != sentence2.length)
            return false;
        
        Set<String> pairsSet = new HashSet<>();
        for(List<String> temp : similarPairs){
            pairsSet.add(temp.get(0) + "#" + temp.get(1));
        }
        
        for(int i=0; i<sentence1.length; i++){
            if(!sentence1[i].equals(sentence2[i]) && !pairsSet.contains(sentence1[i] + "#" + sentence2[i]) && !pairsSet.contains(sentence2[i] + "#" + sentence1[i]))
                return false;
        }
        
        return true;
        
    }
}
