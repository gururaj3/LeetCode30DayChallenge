class Solution {
    public String removeDuplicates(String S) {

        Stack<Character> s = new Stack<>();
        StringBuilder res = new StringBuilder();
       
        s.push(S.charAt(0));
        
        for(int i=1; i<S.length(); i++){
            if(!s.isEmpty() && S.charAt(i) == s.peek()){
                s.pop();
                
            }
            else{   
                s.push(S.charAt(i));       
            }
        }

        for(Character c : s){
            res.append(c);
        }
        return res.toString();
    }
}
