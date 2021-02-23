class Solution {
    HashMap<Integer, List<Integer>> adjList = new HashMap();
    int components = 0;
    
    public int countComponents(int n, int[][] edges) {
        
        buildGraph(n, edges);
        
        HashSet<Integer> visited = new HashSet();
        for(int i = 0; i < n; i++){
            if(!visited.contains(i)){
                components++;
                dfs(i, visited);
            }
        }
        return components;
    }
    
    public void buildGraph(int n, int[][] edges){
         for(int i = 0; i < n; i++)
            adjList.put(i, new ArrayList());
        for(int i = 0; i < edges.length; i++){
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
        }
    }
    
    public void dfs(int i, HashSet<Integer> visited){
        visited.add(i);
        
        for(int node: adjList.get(i))
            if(!visited.contains(node)) 
                dfs(node, visited);
    }
}
