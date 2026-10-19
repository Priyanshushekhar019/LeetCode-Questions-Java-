// class Solution {
//     public static boolean isPrime(int n){
//         for(int i=2;i*i<=n;i++){
//             if(n%i==0){
//                 return false;
//             }
//         }
//         return true;
//     }
//     public int countPrimes(int n) {
//         int count=0;
//         if(n<=1){
//             return 0;
//         }
//         for(int i=2;i<n;i++){
//             if(isPrime(i)){
//                 count++;
//             }
//         }
//         return count;
//     }
// }

class Solution {
    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }

        boolean[] prime = new boolean[n];

        for (int i = 2; i < n; i++) {
            prime[i] = true;
        }

        for (int i = 2; i * i < n; i++) {
            if (prime[i]) {
                for (int j = i * i; j < n; j += i) {
                    prime[j] = false;
                }
            }
        }

        int count = 0;

        for (int i = 2; i < n; i++) {
            if (prime[i]) {
                count++;
            }
        }

        return count;
    }
}
