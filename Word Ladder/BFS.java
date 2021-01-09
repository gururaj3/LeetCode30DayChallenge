//Making use of set is very important because if you use List as it is then you will get a TLE but if you put all the words from the list into set and then make use of the set, then your code will run


class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>(wordList);
        
        if(!set.contains(endWord)) {
            return 0;
        }

        Queue<String> queue= new LinkedList<>();
        
        queue.add(beginWord);
        int level= 1;
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            
            for(int i=0; i <size; i++ ) {
                String s = queue.remove();        //'hit'
                char[] c = s.toCharArray();
                
                for(int j=0; j<c.length; j++) {
                    for( char k='a'; k<='z'; k++) {
                        char temp = c[j];
                        c[j] = k;
                        
                        String s2 = new String(c);
                        
                        if(set.contains(s2)) {
                            if(s2.equals(endWord)) return level+1;
                            queue.add(s2);
                            set.remove(s2);
                        }                    
                        c[j]=temp;
                    }
                }            
            }
            level++;
        }
        return 0;
    }
}
