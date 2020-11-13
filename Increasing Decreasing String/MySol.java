class Solution {
    public String sortString(String s) {
        
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder res = new StringBuilder();
        
        for(int i=0; i<s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        
        for(int k=0; k<s.length(); k++){
            
            for(char i='a'; i<='z'; i++){
                if(map.containsKey(i) && map.get(i)>0){
                    map.put(i, map.get(i)-1);
                    res.append(i);
                }
            }
            for(char i='z'; i>='a'; i--){
                if(map.containsKey(i) && map.get(i)>0){
                    map.put(i, map.get(i)-1);
                    res.append(i);
                }
            }
            
        }
        return res.toString();
    }
}

