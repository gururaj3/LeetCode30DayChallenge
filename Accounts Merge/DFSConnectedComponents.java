class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        
        Map<String, String> emailToName = new HashMap();
        Map<String, ArrayList<String>> graph = new HashMap();
        
        for (List<String> account: accounts) {
            String name = "";
            for (String email: account) {
                if (name == "") {
                    name = email;
                    continue;
                }
                if(!graph.containsKey(email)){
                    graph.put(email, new ArrayList<String>());
                    graph.get(email).add(account.get(1));
                }
                else{
                    graph.get(email).add(account.get(1));
                }
                    
                if(!graph.containsKey(account.get(1))){
                    graph.put(account.get(1), new ArrayList<String>());
                    graph.get(account.get(1)).add(email);
                }
                else{
                    graph.get(account.get(1)).add(email);
                }
                    
                // graph.computeIfAbsent(email, x-> new ArrayList<String>()).add(account.get(1));
                emailToName.put(email, name);
                // graph.computeIfAbsent(account.get(1), x-> new ArrayList<String>()).add(email);
                emailToName.put(email, name);
            }
        }
        
        Set<String> seen = new HashSet();
        List<List<String>> ans = new ArrayList();
        for (String email: graph.keySet()) {
            if (!seen.contains(email)) {
                seen.add(email);
                Stack<String> stack = new Stack();
                stack.push(email);
                List<String> component = new ArrayList();
                while (!stack.empty()) {
                    String node = stack.pop();
                    component.add(node);
                    for (String nei: graph.get(node)) {
                        if (!seen.contains(nei)) {
                            seen.add(nei);
                            stack.push(nei);
                        }
                    }
                }
                Collections.sort(component);
                component.add(0, emailToName.get(email));
                ans.add(component);
            }
        }
        return ans;
    }
}



// [["John", "johnsmith@mail.com", "john00@mail.com"], 
//  ["John", "johnnybravo@mail.com"], 
//  ["John", "johnsmith@mail.com", "john_newyork@mail.com"], 
//  ["Mary", "mary@mail.com"]]
 

