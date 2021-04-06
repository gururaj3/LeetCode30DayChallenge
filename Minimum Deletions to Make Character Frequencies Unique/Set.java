class Solution {
    public int minDeletions(String s) {
        
        if(s.length() <= 1)
            return 0;
        
        int[] count = new int[26];
        HashSet<Integer> set = new HashSet<>();
        int deletions = 0;
        
        for(char c : s.toCharArray()){
            count[c - 'a']++;
        }
        
        for(int i = 0;i < 26; i++){
            if(count[i] != 0)
            {
                if(!set.contains(count[i])){
                    set.add(count[i]);
                }
                else
                {
                    while(set.contains(count[i]))
                    {
                        count[i]--;
                        deletions++;
                    }

                    if(count[i] != 0)
                    {
                        set.add(count[i]);
                    }
                }
            }
        }
        return deletions;
    }
}
