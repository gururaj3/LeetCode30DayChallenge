class Solution {
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> list = new ArrayList<>();
        
        if(null == arr1 || null == arr2 || null == arr3 ||
          arr1.length < 1 || arr2.length < 1 || arr3.length < 1)
        {
            return list;
        }
        
        int idx1 = 0;
        int idx2 = 0;
        int idx3 = 0;
        
        while(idx1 < arr1.length && idx2 < arr2.length && idx3 < arr3.length)
        {
            if(arr1[idx1] == arr2[idx2] && arr2[idx2] == arr3[idx3])
            {
                list.add(arr1[idx1]);
                idx1++;
                idx2++;
                idx3++;
            }
            
            if(idx1 >= arr1.length || idx2 >= arr2.length || idx3 >= arr3.length)
            {
                return list;
            }
            
            int nextLargest = Math.max(arr1[idx1], Math.max(arr2[idx2], arr3[idx3]));
            
            while(idx1 < arr1.length && arr1[idx1] < nextLargest)
            {
                idx1++;
            }
            while(idx2 < arr2.length && arr2[idx2] < nextLargest)
            {
                idx2++;
            }
            while(idx3 < arr3.length && arr3[idx3] < nextLargest)
            {
                idx3++;
            }
        }
        
        return list;
    }
}