public class Codec {

    Stack<String> stack = new Stack<>();
    
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        
        StringBuilder sb = new StringBuilder();
        
        
        for(String s : strs){
            stack.push(s);
            sb.append(s);
        }
        
        return sb.toString();
        
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> list = new ArrayList<>();
        while(!stack.isEmpty())
            list.add(0, stack.pop());
        
        return list;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));