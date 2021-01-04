/**
 * // This is the HtmlParser's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface HtmlParser {
 *     public List<String> getUrls(String url) {}
 * }
 */

class Solution {
    
    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        
        Queue<String> queue = new LinkedList<>();
        queue.add(startUrl);
        
        String hostUrl = getHostName(startUrl);
        
        Set<String> res = new HashSet<>();
        
        while (!queue.isEmpty()){
            
            String url = queue.poll();
            res.add(url);
            
            for(String childUrl : htmlParser.getUrls(url))
                if(getHostName(childUrl).equals(hostUrl) && !res.contains(childUrl)){
                    queue.add(childUrl);
                }
        } 
        return new ArrayList<>(res);
    }

    private String getHostName(String url) {
        int idx = url.indexOf("http://");
        if (idx >= 0) {
            url = url.substring("http://".length());
        }
        String[] parts = url.split("/");
        return parts[0];
    }
}
