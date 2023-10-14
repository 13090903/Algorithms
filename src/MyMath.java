import java.util.*;

public class MyMath {
    static Random random = new Random();
    static int mod = 1000000007;

    static long fact(long n) {
        long ans = 1;
        for (int i = 1; i <= n; i++) {
            ans = (ans % mod * i % mod) % mod;
        }
        return ans;
    }

    static long fastPower(long a, long n) {
        if (n == 0) {
            return 1;
        }
        long a2 = fastPower(a, n / 2);
        long res = a2 * a2 % mod * (n % 2 == 1 ? a : 1);
        return res % mod;
    }

    static long modInverse(long n, long p) {
        return fastPower(n, p - 2);
    }
    public static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    static long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }
    static boolean isPrime(int n) {
        if (n <= 1)
            return false;
        else if (n == 2)
            return true;
        else if (n % 2 == 0)
            return false;
        for (int i = 3; i*i <= n; i += 2) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
    static ArrayList<Integer> primes; // Generated by sieve algorithm;
    static int[] prime = new int[(int)1e7 + 1];

    public static void sieve() { // Complexity O(Nlog(log(N));
        primes = new ArrayList<>();
        Arrays.fill(prime, 1);
        prime[0] = prime[1] = 0;
        for (int i = 2; i <= (int)1e7; i++) {
            if (prime[i] == 1) {
                for (long j = (long) i * i; j <=(int)1e7; j += i)
                    prime[(int) j] = 0;
                primes.add(i);
            }
        }
    }
    public static TreeSet<Integer> primeFactors(int N) { // Complexity O(sqrt(N) / ln (sqrt(N)));
        TreeSet<Integer> factors = new TreeSet<>();
        int PF_idx = 0;
        int PF = primes.get(PF_idx); // primes has been populated by sieve
        while (PF * PF <= N) { // stop at sqrt(N); N can get smaller
            while (N % PF == 0) {
                N /= PF;
                factors.add(PF);
            } // remove PF
            PF = primes.get(++PF_idx); // only consider primes!
        }
        if (N != 1)
            factors.add(N); // special case if N is a prime
        return factors; // if N does not fit in 32-bit integer and is a prime
    }

}