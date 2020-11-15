class Solution {
	public int[] frequencySort(int[] nums) {
		Arrays.sort(nums);
		Map<Integer,List<Integer>> map = new TreeMap<>();
		int start = 0;
		int end = 0;
		int freq = 1;
		
		//create a sorted map(frequency, List{all elements with such frequency from nums[]})
		for (int i = 1; i <nums.length; i++) {
			start = end;
			if(nums[i] != nums[i-1]){
				end = i;
				if(!map.containsKey(freq)){
					List<Integer> list = new ArrayList<>();
					for (int j = 0; j < end-start ; j++) {
						list.add(nums[i-1]);
					}
					map.put(freq, list);
				}else{
					for (int j = 0; j < end-start ; j++) {
						map.get(freq).add(nums[i-1]);
					}
				}
				freq = 0;
			}
			freq++;
		}
        
		// add the last element/s from num[] into map
		if(!map.containsKey(freq)){
			List<Integer> list = new ArrayList<>();
			for (int j = 0; j < nums.length-end ; j++) {
				list.add(nums[nums.length-1]);
			}
			map.put(freq, list);
		}else{
			for (int j = 0; j < nums.length-end ; j++) {
				map.get(freq).add(nums[nums.length-1]);
			}
		}
        
		int i = 0;
		
		// iterate over map's values and from right to left overwrite i index in arr[] 
		for (List<Integer> list : map.values()) {
			for (int j = list.size()-1; j >= 0 ; j--) {
				nums[i++] = list.get(j);
			}
		}
		return nums;
	}
}
