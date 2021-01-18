public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        if (s1.length() > s2.length())
            return false;
        
        HashMap < Character, Integer > s1map = new HashMap < > ();
        
        for (int i = 0; i < s1.length(); i++)
            s1map.put(s1.charAt(i), s1map.getOrDefault(s1.charAt(i), 0) + 1);
        
        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            HashMap < Character, Integer > s2map = new HashMap < > ();
            for (int j = 0; j < s1.length(); j++) {
                s2map.put(s2.charAt(i + j), s2map.getOrDefault(s2.charAt(i + j), 0) + 1);
            }
            if(s1map.equals(s2map))
                return true;
        }
        return false;
    }
    
}

