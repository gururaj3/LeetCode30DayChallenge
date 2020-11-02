/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    int max = 0;
    
    public int depthSumInverse(List<NestedInteger> nestedList) {
        
        int d = dfs1(nestedList, 1);
        return dfs(nestedList, d+1);       
        
    }
    
    public int dfs1(List<NestedInteger> nestedList, int depth){
        
        for(int i=0; i<nestedList.size(); i++){
            NestedInteger n = nestedList.get(i);
            if(!n.isInteger()){
                if(depth> max){
                    max = depth;
                }
                dfs1(n.getList(), depth + 1);  
            }
        }
        return max;
    }
    
    public int dfs(List<NestedInteger> nestedList, int depth){
        
        int sum = 0;
        
        for(int i=0; i<nestedList.size(); i++){
            
            NestedInteger n = nestedList.get(i);
            if(n.isInteger()){
                sum += n.getInteger() * depth;
            }
            else{
                sum += dfs(n.getList(), depth-1);
            } 
        }
        return sum;
        
    }
}
