//Refer https://www.youtube.com/watch?v=binXv9-uT3A

class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        
        List<Integer> res = new ArrayList<>();
        
        for(int i=0; i<input.length(); i++){
            char c = input.charAt(i);
            if(c == '-' || c == '+' || c == '*'){
                String a = input.substring(0, i);
                String b = input.substring(i+1);
                List<Integer> left = diffWaysToCompute(a);
                List<Integer> right = diffWaysToCompute(b);
                
                for(int x : left){
                    for(int y : right){
                        if(c == '-')
                            res.add(x-y);
                        if(c == '+')
                            res.add(x+y);
                        if(c == '*')
                            res.add(x*y);    
                    }
                }
            }
        }
        if(res.size() == 0){
            res.add(Integer.valueOf(input));
        }
        return res;
    }
}
