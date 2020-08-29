class Solution {
    public int[][] highFive(int[][] items) {
        HashMap<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for (int[] arr: items) {
            if (!map.containsKey(arr[0]))
                map.put(arr[0], new PriorityQueue<Integer>(new Comparator<Integer>() {
                    @Override
                    public int compare(Integer num1, Integer num2) {
                        return num2.compareTo(num1);
                    }
                }));
            
            map.get(arr[0]).add(arr[1]);
        }
        int[][] retArr = new int[map.size()][2];
        int i = 0;
        for (Map.Entry<Integer, PriorityQueue<Integer>> entry: map.entrySet()) {
            retArr[i][0] = entry.getKey();
            for (int j = 0; j < 5; j++)
                retArr[i][1] += entry.getValue().remove();
            retArr[i][1] /= 5;
            i++;
        }
        return retArr;
    }
}
