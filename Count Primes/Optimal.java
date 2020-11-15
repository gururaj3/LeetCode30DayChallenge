//1. Create a boolean array of n numbers and make all of it as True
//2. Iterate over those n numbers from i=2 to i*i<n (p*q<=n => p*p<=n => p<=sqrt(n))
//3. Iterate from j=i*i; j<n; j+=i, j=i*i because all the numbers before that which are non-primes would have already been set to False. j+=i basically goes over the multiples of j from j*j


class Solution {
    public int countPrimes(int n) {
        
       boolean[] isPrime = new boolean[n];
       for (int i = 2; i < n; i++) {
          isPrime[i] = true;
       }
   // Loop's ending condition is i * i < n instead of i < sqrt(n)
   // to avoid repeatedly calling an expensive function sqrt().
   
        for (int i = 2; i * i < n; i++) {
          if (!isPrime[i]) continue;
          for (int j = i * i; j < n; j += i) {
             isPrime[j] = false;
          }
       }
        
       int count = 0;
       for (int i = 2; i < n; i++) {
          if (isPrime[i]) count++;
       }
        
    return count;
    }
}
