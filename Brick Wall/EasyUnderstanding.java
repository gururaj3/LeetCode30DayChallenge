/*
1. Get the overall width of the wall(By traversing the first list andd adding all it's elements, all elements in any list of the wall add up to the width of the wall)
2. Initialize an pos[] array which will hold the indices of the lists to be checked currently and also initialize a res variable to be Integer.MAX_VALUE 
3. Iterate over the width of the wall
4. Initialize count=0 which will store the number of bricks crossed at each iteration
5. Iterate over the lists in wall and do:
    1. check list.get(pos[i])!=0, then increase count++ which means the line crosses this brick
    2. else increase pos[i]++ to make set the next index in the list
    3. Update the value in the list by doing list.set(pos[i], list.get(pos[i]-1))
    4. Decrement the width of the brick and update the minimum(res, count)
6. return res
*/




public class Solution {
    public int leastBricks(List < List < Integer >> wall) {
        
        int[] pos = new int[wall.size()];
        
        int c = 0, sum = 0, res = Integer.MAX_VALUE;
        
        for (int el: wall.get(0))
            sum += el;
        
        while (sum != 0) {
            int count = 0;
            for (int i = 0; i < wall.size(); i++) {
                List < Integer > row = wall.get(i);
                if (row.get(pos[i]) != 0)
                    count++;
                else
                    pos[i]++;
                row.set(pos[i], row.get(pos[i]) - 1);
            }
            sum--;
            res = Math.min(res, count);
        }
        return res;
        
    }
}

// [[1,2,1],
//  [3,1],
//  [2,2]]



