class Solution {
    public int numTeams(int[] rating) {
        int res = 0;
        for(int i=1; i<rating.length-1; i++){
            
            int leftLess = 0 ;
            int leftGreater = 0;
            
            int rightLess = 0;
            int rightGreater = 0;
            
            for(int j=i-1; j>=0; j--){
                if(rating[i] > rating[j])
                    leftLess++;
                else
                    leftGreater++;
            }
            
            for(int j=i+1; j<rating.length; j++){
                if(rating[i] > rating[j])
                    rightLess++;
                else
                    rightGreater++;
            }
            res += (leftLess*rightGreater) + (leftGreater*rightLess);
        }
        return res;
    }
}

/*

 you need to choose 3 numbers, if i pick middle element then number of elements on leftless * rightgreater give me count for all combination for i<j<k, rating(i)>rating(j)>rating(k) similarly other way round, and if add both we get total count of combinations

*/
