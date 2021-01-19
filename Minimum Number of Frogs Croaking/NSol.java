class Solution {
    public int minNumberOfFrogs(String croakOfFrogs) {
        
        String CROAK = "croak";
        int res = 0;
        int[] sound = new int[5];

        for (char c : croakOfFrogs.toCharArray()) {
		
		    //return -1 if not one of the desired letter
            int idx = CROAK.indexOf(c);
            if (idx == -1) {
                return -1;
            }

            //if first letter, increase count, store max
            if (idx == 0) {
                sound[0]++;
                res = Math.max(res, sound[0]);
            } else {
			
			    //if current letter more than previous, return -1
                if (sound[idx - 1] <= sound[idx]) {
                    return -1;
                }
				
				//if this is the last letter, reduce count for all letters
				//else increase current letter count
                if (idx == 4) {
                    for (int i = 0; i < idx; i++) {
                        sound[i]--;
                    }
                } else {
                    sound[idx]++;
                }
            }
        }
		
		//if there are outstanding letters, return -1, else return max value
        return (sound[0] > 0) ? -1 : res;
    }
}
