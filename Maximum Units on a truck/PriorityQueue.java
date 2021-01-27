class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        
        // Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        Queue<int[]> heap = new PriorityQueue<>(
        (a, b) -> b[1] - a[1]);
        
        for(int i[] : boxTypes){
            heap.add(i);
        }
 
        int unitCount = 0;
        while (!heap.isEmpty()) {
            int[] boxType = heap.poll();
            int boxCount = Math.min(truckSize, boxType[0]);
            unitCount += boxCount * boxType[1];
            truckSize -= boxCount;
            if (truckSize == 0)
                break;
        }
        return unitCount;
    }
}

// [[1,3], -> 3
//  [2,2], -> 4
//  [3,1]] -> 3
// 3+
// 4+
// 1
 
// [[5,10], -> 50
//  [2,5], -> 10
//  [4,7], -> 28
//  [3,9]] -> 27
    
// 50+ (10, 5)
// 27+ (5, 3)
// 14+ (2, 4)
    
// 50+
// 28+
// 9



