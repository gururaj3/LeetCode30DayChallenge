class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        
        Map<Integer, Integer> map = new HashMap<>();
        
        Queue<Integer> heap = new PriorityQueue<>(
        (n1, n2) -> map.get(n1) - map.get(n2));
        
        for(int i : arr){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
    
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            heap.add(entry.getKey());
        }
        
        for(int i=0; i<k; i++){
                if(map.get(heap.peek()) == 1){
                    heap.poll();
                }
                else{
                    map.put(heap.peek(), map.get(heap.peek()) - 1);
                }
            
        }
        return heap.size();
    }
}


