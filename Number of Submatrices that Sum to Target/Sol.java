class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        
        int r = matrix.length, c = matrix[0].length;
        for(int i=0; i<r; i++){
            for(int j=1; j<c; j++){
                matrix[i][j] += matrix[i][j-1];
            }
        }
        
        int count = 0, currSum;
        Map<Integer, Integer> h = new HashMap();
        
        for(int c1=0 ; c1<c; c1++){
            for(int c2=c1; c2<c; c2++){
                System.out.println("*****c1: "+c1+" c2: "+c2);
                h.clear();
                h.put(0, 1);
                currSum = 0;
                for (int row = 0; row < r; ++row) {
                      // current 1D prefix sum 
                      currSum += matrix[row][c2] - (c1>0 ? matrix[row][c1 - 1] : 0);

                      // add subarrays which sum up to (currSum - target)
                      count += h.getOrDefault(currSum - target, 0);

                      // save current prefix sum
                      h.put(currSum, h.getOrDefault(currSum, 0) + 1);
                    System.out.println("cS: "+currSum);
                    System.out.println("count: "+count);
                    System.out.println("map: "+h);
                }
            }
        }
        return count;
    }
}

/*

[[0,1,0],                           [[0,1,1],
[1,1,1], ->prefix sum for all rows   [1,2,3],
[0,1,0]]                             [0,1,1]]

1. Find prefix sum for all rows
2. Now, take 2 columns and add sum as you go down each row for that column, like performing 1D prefix sum down that column.
3. We subtract the current matrix prefix sum from the previous matrix prefix sum to get the current value to add it.
4. I have added the matrix before each c1 and c2 with thier current values.

[[0,1,1],
 [1,2,3],
 [0,1,1]]
*****c1: 0 c2: 0
cS: 0
count: 1
map: {0=2}
cS: 1
count: 1
map: {0=2, 1=1}
cS: 1
count: 2
map: {0=2, 1=2}
[[0,1,1],
 [1,2,3],
 [0,1,1]]
*****c1: 0 c2: 1
cS: 1
count: 2
map: {0=1, 1=1}
cS: 3
count: 2
map: {0=1, 1=1, 3=1}
cS: 4
count: 2
map: {0=1, 1=1, 3=1, 4=1}
*****c1: 0 c2: 2
[[0,1,1],
 [1,2,3],
 [0,1,1]]
cS: 1
count: 2
map: {0=1, 1=1}
cS: 4
count: 2
map: {0=1, 1=1, 4=1}
cS: 5
count: 2
map: {0=1, 1=1, 4=1, 5=1}
*****c1: 1 c2: 1
[[0,1,1],
 [1,1,3],
 [0,1,1]]
cS: 1
count: 2
map: {0=1, 1=1}
cS: 2
count: 2
map: {0=1, 1=1, 2=1}
cS: 3
count: 2
map: {0=1, 1=1, 2=1, 3=1}
*****c1: 1 c2: 2
[[0,1,1],
 [1,2,2],
 [0,1,1]]
cS: 1
count: 2
map: {0=1, 1=1}
cS: 3
count: 2
map: {0=1, 1=1, 3=1}
cS: 4
count: 2
map: {0=1, 1=1, 3=1, 4=1}
*****c1: 2 c2: 2
[[0,1,0],
 [1,2,1],
 [0,1,0]]
cS: 0
count: 3
map: {0=2}
cS: 1
count: 3
map: {0=2, 1=1}
cS: 1
count: 4
map: {0=2, 1=2}

*/
