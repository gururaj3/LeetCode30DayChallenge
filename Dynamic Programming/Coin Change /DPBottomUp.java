class Solution {
    public int coinChange(int[] coins, int amount) {
    
        int max = amount + 1;
        int c[] = new int[amount+1];
        Arrays.fill(c, max);
        
        c[0] = 0;
        for(int p=1; p<=amount; p++){
            
            for(int i=0; i<coins.length; i++){
                if(coins[i] <= p){
                        c[p] = Math.min(c[p], c[p - coins[i]] + 1);
                }
            }
            
        }
        return c[amount] > amount ? -1 : c[amount];
    }
}
