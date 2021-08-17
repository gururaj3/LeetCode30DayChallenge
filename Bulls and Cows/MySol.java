class Solution {
    public String getHint(String secret, String guess) {
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<secret.length(); i++){
            map.put(secret.charAt(i)-'0', map.getOrDefault(secret.charAt(i)-'0', 0)+1);
        }
        
        Set<Integer> bullSet = new HashSet<>();
        
        for(int i=0; i<secret.length(); i++){
            if(secret.charAt(i) == guess.charAt(i)){
                bullSet.add(i);
                map.put(secret.charAt(i)-'0', map.get(secret.charAt(i)-'0')-1);
            } 
        }
        
        int bullCount = bullSet.size();
        int cowCount = 0;
        
        for(int i=0; i<guess.length(); i++){
            // System.out.println("guess: "+guess.charAt(i));
            if(map.containsKey(guess.charAt(i)-'0') && map.get(guess.charAt(i)-'0')>0 && !bullSet.contains(i)){
                // System.out.println(guess.charAt(i));
                map.put(guess.charAt(i)-'0', map.get(guess.charAt(i)-'0')-1);
                cowCount++;
            }
            
        }
        return String.valueOf(bullCount)+"A"+String.valueOf(cowCount)+"B";
    }
}

/*
bulls- digits in the guess that are in the correct position
cows-digits in the guess that are in your secret number but are located in the wrong position

secret = "1807", 
guess =  "7810"

no. of bulls = 1
no. of cows = 3
Hint 1A3B

secret = "1123", 
guess =  "0111"

no. of bulls = 1
no. of cows = 1
Hint 1A1B

Brute Force:
map1->digit,count which conatins digits from secret
Have 2 pointers and iterate to count bulls and save thier positions in a bullset

Now iterate over guess
1. If digit not in bullset
2. count--

*/
