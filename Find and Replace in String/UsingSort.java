class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        
        StringBuilder res = new StringBuilder(s);
        Map<Integer, String> sourcesMap = new HashMap<>();
        Map<Integer, String> targetsMap = new HashMap<>();
        
        for(int i = 0; i< indices.length; i++ ) {
            sourcesMap.put(indices[i], sources[i]);
            targetsMap.put(indices[i], targets[i]);
        }
        
        //So we can iterate from the back with updating the largest index first
        Arrays.sort(indices);
        
        //We start from the back so that we don't overlap the indices and the question says that there will be no testcase which will have indices overlapping. 
        for(int i = indices.length-1; i >= 0; i--) {
            
            String source = sourcesMap.get(indices[i]);
            String target = targetsMap.get(indices[i]);
            
            int srcLength = source.length();
            String subStr = s.substring(indices[i], indices[i] + srcLength);
            
             if(subStr.equals(source)) {
                res.replace(indices[i], indices[i] + srcLength, target);
            }
        }
        
        return res.toString();
    }
}

/*

s="abcd"
indices[i] = 0, sources[i] = "ab", targets[i] = "eee"
indices[i] = 2, sources[i] = "cd", targets[i] = "rrr"

source = "cd"
target = "rrr"

subStr = "cd"

if()



*/
