class RLEIterator {

    int[] arr;
    int i;

    public RLEIterator(int[] encoding) {
        this.arr = encoding;
        this.i = 0;

    }
    
    public int next(int n) {
        int res = -1;
        while(i < arr.length && n>0) {
            if(arr[i] >= n){
                arr[i] -= n;
                n = 0;
                res =arr[i+1];
            } else {
                n -= arr[i];
                i += 2;
            }
        }
        return res;
    }
}

/**
 * Your RLEIterator object will be instantiated and called as such:
 * RLEIterator obj = new RLEIterator(encoding);
 * int param_1 = obj.next(n);
 */

/*
[[3, 8, 0, 9, 2, 5]]

next(2)
res=-1
whie(0<6){
    if(arr[0] >= n)
        arr[i] -=n
        n=0
        res = 8
}




*/
