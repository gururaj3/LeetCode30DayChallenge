class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        
        
// to map indices with sources and targets. 
// This map will handle everything even if the indices are not sorted. 
// Map<indices[index] , index>
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < indices.length; i++){
            map.put(indices[i], i);
        }
        
//result string must be a stringbuilder/stringbuffer as we cannot perform operations on the string as it may change the indices of rest of the character in the original string s
        
		StringBuilder str = new StringBuilder();
        
//traverse through the string, and check if that index exists in our map index
// if exists, check the length of the source and check if the source matches with our current substring in s.
// if yes then only make changes and shift the pointer accordingly else append s.charAt(i)

        for(int i = 0; i < s.length(); i++){
            if(map.containsKey(i)){
                int sourceLength = sources[map.get(i)].length();
                
				if(s.substring(i, i + sourceLength).equals(sources[map.get(i)])){
                    str.append(targets[map.get(i)]);
                    i = i + sourceLength - 1;
                }else{
                    str.append(s.charAt(i));
                }
            }else{
                str.append(s.charAt(i));
            }
        }
        
        return str.toString();
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
