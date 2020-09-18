class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        
        List<String> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        
        for(String s : cpdomains){
            
            int count = Integer.parseInt(s.split(" ")[0]);
            
            String domain = s.split(" ")[1];
            
            String[] listOfDomains = domain.split("\\.");
            if(listOfDomains.length == 2){
                if(!map.containsKey(listOfDomains[1]))
                    map.put(listOfDomains[1], count);
                else{
                    map.put(listOfDomains[1], map.getOrDefault(listOfDomains[1], 0) + count);
                }
                String temp = listOfDomains[0].concat(".").concat(listOfDomains[1]);
                if(!map.containsKey(temp))
                    map.put(temp, count);
                else{
                    map.put(temp, map.getOrDefault(temp, 0) + count);
                }
            }
            if(listOfDomains.length == 3){
                if(!map.containsKey(listOfDomains[2]))
                    map.put(listOfDomains[2], count);
                else{
                    map.put(listOfDomains[2], map.getOrDefault(listOfDomains[2], 0) + count);
                }
                String temp = listOfDomains[1].concat(".").concat(listOfDomains[2]);
                if(!map.containsKey(temp))
                    map.put(temp, count);
                else{
                    map.put(temp, map.getOrDefault(temp, 0) + count);
                }
                String temp1 = listOfDomains[0].concat(".").concat(listOfDomains[1]).concat(".").concat(listOfDomains[2]);
               
                if(!map.containsKey(temp1))
                    map.put(temp1, count);
                else{
                    map.put(temp1, map.getOrDefault(temp1, 0) + count);
                }
            }
            
        }
        
        for (Map.Entry<String,Integer> entry : map.entrySet()){
            String temp2 = Integer.toString(entry.getValue()).concat(" ").concat(entry.getKey());
            
            result.add(temp2);
        }  
        return result;
    }
}
