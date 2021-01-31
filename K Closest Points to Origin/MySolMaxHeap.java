class Solution {
public int[][] kClosest(int[][] points, int K) {
    
    int[][] res = new int[K][2];
    if(points.length == 0) 
        return res;

    PriorityQueue<int[]> topK = new PriorityQueue<>((a,b)-> (b[0]*b[0] + b[1]*b[1]) - (a[0]*a[0] + a[1]*a[1]));
    
    int j =0;
    for (int i = 0; i < points.length; i++) {
            topK.add(points[i]);
            if(topK.size() > K){
                topK.poll();
            }
    }
    for (int i = 0; i < res.length; i++) {
        res[i] = topK.poll();
    }
    
    return res;
    }
}

