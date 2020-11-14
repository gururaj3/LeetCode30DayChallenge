class Solution {
    public String sortString(String s) {
        
        int start = 25;
        int end = 0;
        int [] map = new int[26];

        for(char c : s.toCharArray()) {
            if(c - 'a'< start) start = c - 'a';
            if(c - 'a'> end) end = c - 'a';
            map[c-'a']++;
        }

        int count = s.length(), j = 0;
        StringBuilder res = new StringBuilder();

        while(count > 0){
            for(int i = start; i <= end; i++)
                if(map[i]> 0) {
                    map[i]--;
                    res.append((char)(i+'a'));
                    count--;
                }
            
            for(int i = end; i >= start; i--)
                if(map[i]> 0) {
                    map[i]--;
                    res.append((char)(i+'a'));
                    count--;
                }
            
        }
        
        return res.toString();
        
    }
}
