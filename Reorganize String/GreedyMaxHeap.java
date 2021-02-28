class Solution {
    public String reorganizeString(String S) {
        
        Map<Character, Integer> map = new HashMap<>();
        
        for(char c : S.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);
        
        Queue<Character> maxHeap = new PriorityQueue<>(
        (a, b) -> map.get(b) - map.get(a)
        );
        
        maxHeap.addAll(map.keySet());
        
        StringBuilder ans = new StringBuilder();
        while(maxHeap.size() > 1){
            char curr = maxHeap.poll();
            char next = maxHeap.poll();
            
            ans.append(curr).append(next);
             
            map.put(curr, map.get(curr) - 1);
            map.put(next, map.get(next) - 1);
            if(map.get(curr) > 0)
                maxHeap.add(curr);
            if(map.get(next) > 0)
                maxHeap.add(next);
        }
        
        if(!maxHeap.isEmpty()){
            char last = maxHeap.poll();
            if(map.get(last)>1)
                return "";
            ans.append(last);
        }
        return ans.toString();
    }
}

// Time Complexity - O(NLogN) because of the while loop, iterating over maxheap.size and adding to heap takes LogN to rearrange heap
