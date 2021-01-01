class Solution {
    public boolean wordPattern(String pattern, String s) {

        Map<Character, String> map = new HashMap<>();
        
        String[] c = s.split(" ");
        if(pattern.length() != c.length)
            return false;
        
        for(int i=0; i<pattern.length(); i++){
            
            if(map.containsKey(pattern.charAt(i)) && !map.get(pattern.charAt(i)).equals(c[i])
               || (!map.containsKey(pattern.charAt(i)) && map.containsValue(c[i])) ){
                // System.out.println("map");
                return false;
            }
                
            
            map.put(pattern.charAt(i), c[i]);
            // System.out.println(map); 
        }     
        return true;   
    }
}
// a -> dog
