class Solution {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        
        // System.out.println("sx: " +sx+ " sy: " +sy+ " tx: " +tx+ " ty: " +ty);
        
        if(sx == tx && sy == ty)
            return true;
        if(sx > tx || sy > ty)
            return false;
              
        return reachingPoints(sx, sy+sx, tx, ty) || reachingPoints(sx+sy, sy, tx, ty);
    }
}
