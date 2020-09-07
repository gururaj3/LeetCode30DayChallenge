class Solution {
    public int findShortestSubArray(int[] nums) {
        
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int count = Integer.MAX_VALUE;
        // int v = 1;
        
        for(int i: nums)
            list.add(i);
        
        for(int i : nums)
            map.put(i, map.getOrDefault(i, 0) + 1);
        
        // for (Map.Entry<Integer, Integer> entry : map.entrySet()){
        //     int val = entry.getValue();
        //     if(v < val)
        //         v = val;
        // } Use this OR below one statement
        
        int v = Collections.max(map.values()); 
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int val = entry.getValue();
            if(v == val){
                int c = (list.lastIndexOf(key) - list.indexOf(key)) + 1;
                if(c < count && c!=1)
                    count = c;
            }
    }
        return (count!=1 && count!=Integer.MAX_VALUE) ? count : 1;
    }
}
