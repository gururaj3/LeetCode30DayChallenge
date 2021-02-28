class Solution {
    public List<Integer> partitionLabels(String S) {
        
        List<Integer> res = new ArrayList<>();
        
        int[] lastIndexes = new int[26];
        for(int i=0; i<S.length(); i++){
            lastIndexes[S.charAt(i) - 'a'] = i;
        }
        
        int i=0;
        while(i<S.length()){
            int end = lastIndexes[S.charAt(i) - 'a'];
            int j=i;
            while(j!=end){
                end = Math.max(end, lastIndexes[S.charAt(j) - 'a']);
                j++;
            }
            res.add(j-i+1);
            i = j+1;
        }
        
        return res;
        
    }
}

Time Complexity - O(n) because we would be travesing each character only once
