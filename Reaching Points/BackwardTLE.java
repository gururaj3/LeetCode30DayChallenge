class Solution {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        
        while(tx>=sx && ty>=sy ){
            
            if(tx == sx && ty == sy)
                return true;
            
            if(tx>=ty){
                tx = tx - ty;
                ty = ty;
            }
            else{
                tx = tx;
                ty = ty - tx;
            }
        }
        return false;
        
    }
}
