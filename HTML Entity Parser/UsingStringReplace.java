// Be careful that we need to put replace("&amp;", "&") at the end since "&" is part of other entities.
// "&amp;quot;" should be "&quot;".

class Solution {
    public String entityParser(String text) {
        
        text = text.replace("&quot;", "\"");
        text = text.replace("&apos;", "'");
        text = text.replace("&gt;", ">");
        text = text.replace("&lt;", "<");
        text = text.replace("&frasl;", "/");
        text = text.replace("&amp;", "&");
        return text;
        
    }
}
