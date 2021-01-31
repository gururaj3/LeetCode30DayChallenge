class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        
        paragraph = paragraph.replaceAll("[^a-zA-Z0-9]", " "); 
        paragraph = paragraph.toLowerCase();

        String[] strs = paragraph.split("\\s+");
        
        Map<String, Integer> map = new TreeMap<>();
        for(String s : strs){
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        
        for(String s : banned){
            if(map.containsKey(s)){
                map.remove(s);
            }
        }
        int val = Collections.max(map.values());
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            if(entry.getValue() == val)
                return entry.getKey();
        }
        
        
        return "";
        
    }
}
