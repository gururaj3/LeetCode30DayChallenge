//Refer Nideesh Terapalli youtube video for explanation

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] indegree = new int[numCourses];
        
        for(int[] pre : prerequisites){
            List<Integer> l = map.getOrDefault(pre[1], new ArrayList<>());
            l.add(pre[0]);
            
            indegree[pre[0]]++;
            
            map.put(pre[1], l);
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0; i<indegree.length; i++){
            if(indegree[i] == 0)
                q.add(i);
        }
        
        int count = 0;
        
        while(!q.isEmpty()){
            int curr = q.poll();
            
            if(indegree[curr] == 0){
                count++;
            }
            if(!map.containsKey(curr))
                continue;
            
            for(int nei : map.get(curr)){
                indegree[nei]--;
                if(indegree[nei]== 0) q.add(nei);
            }
        }
        return count==numCourses;
        
    }
}
