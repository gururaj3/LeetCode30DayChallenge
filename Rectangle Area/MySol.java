class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        
        if(A==C || B==D)
            return Math.abs(G-E)*Math.abs(H-F);
        if(E==G || F==H)
            return Math.abs(C-A)*Math.abs(D-B);
        if(A==C || B==D && E==G || F==H)
            return 0;
        
        if(A<G && B<H && E<C && F<D){
            int x = Math.abs(Math.max(A, E) - Math.min(C, G));
            int y = Math.abs(Math.max(B, F) - Math.min(D, H));
            return Math.abs(C-A)*Math.abs(D-B) + Math.abs(G-E)*Math.abs(H-F) - x*y;
        }
        
        return Math.abs(C-A)*Math.abs(D-B) + Math.abs(G-E)*Math.abs(H-F);
    }
}
