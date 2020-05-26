class Solution {
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        
        List<Integer> list = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();
        
        for(int i=0; i<arr1.length;i++)
                list.add(arr1[i]);
        
        for(int i=0; i<arr2.length;i++){
            if(list.contains(arr2[i]))
                list2.add(arr2[i]);
        }
        
        for(int i=0; i<arr3.length;i++){
            if(list2.contains(arr3[i]))
                list3.add(arr3[i]);
            
        }
        return list3;
    }
}