class Solution {
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((p1,p2) -> p1[0]*p1[0] + p1[1]*p1[1] - p2[0]*p2[0] - p2[1]*p2[1]);
        for(int[] arr : points){
            pq.add(arr);
        }
        int[][] ans = new int[K][2];
        int i=0;
        while(K-->0){
            int[] temp = pq.poll();
            ans[i][0] = temp[0];
            ans[i++][1] = temp[1];
        }
        return ans;
    }
}


/*
Alternative approach - 

Explicit set queue size to K to reduce space to O(K):

class Solution {
public int[][] kClosest(int[][] points, int K) {
int[][] res = new int[K][2];
if(points.length == 0) return res;

    PriorityQueue<int[]> topK = new PriorityQueue<>(K, (a,b)->a[0]*a[0] + a[1]*a[1] - b[0]*b[0] - b[1]*b[1]);
    
    for (int i = 0; i < points.length; i++) {
        if (points[i].length > 0) {
            topK.add(points[i]);
        }
    }
    
    for (int i = 0; i < res.length; i++) {
        res[i] = topK.poll();
    }
    
    return res;
}
}

*/
