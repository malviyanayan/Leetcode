class Leetcode2338{

    static final int MOD = 1_000_000_007;
    static int[] smallestPrime;
    static long[] fact, invFact;

    public int idealArrays(int n, int maxValue) {
        // Step 1: Precompute smallest prime factors
        computeSmallestPrimes(maxValue);

        // Step 2: Precompute factorials and inverse factorials
        int limit = n + 10000; // Safe bound for large exponents
        precomputeFactorials(limit);

        long result = 0;

        // Step 3: For each number from 1 to maxValue
        for (int i = 1; i <= maxValue; i++) {
            Map<Integer, Integer> primeExponents = factorize(i);
            long ways = 1;

            for (int exp : primeExponents.values()) {
                ways = (ways * nCr(n - 1 + exp, exp)) % MOD;
            }

            result = (result + ways) % MOD;
        }

        return (int) result;
    }

    // Step 1: Sieve of Eratosthenes for smallest primes
    private void computeSmallestPrimes(int max) {
        smallestPrime = new int[max + 1];
        for (int i = 2; i <= max; i++) {
            if (smallestPrime[i] == 0) {
                for (int j = i; j <= max; j += i) {
                    if (smallestPrime[j] == 0)
                        smallestPrime[j] = i;
                }
            }
        }
    }

    // Step 2: Precompute factorials and inverse factorials
    private void precomputeFactorials(int size) {
        fact = new long[size + 1];
        invFact = new long[size + 1];
        fact[0] = 1;
        for (int i = 1; i <= size; i++) {
            fact[i] = (fact[i - 1] * i) % MOD;
        }
        invFact[size] = modInverse(fact[size]);
        for (int i = size - 1; i >= 0; i--) {
            invFact[i] = (invFact[i + 1] * (i + 1)) % MOD;
        }
    }

    // Step 3: Compute nCr using factorials
    private long nCr(int n, int r) {
        if (r < 0 || r > n) return 0;
        return fact[n] * invFact[r] % MOD * invFact[n - r] % MOD;
    }

    // Step 4: Prime factorization using precomputed smallest primes
    private Map<Integer, Integer> factorize(int num) {
        Map<Integer, Integer> map = new HashMap<>();
        while (num > 1) {
            int p = smallestPrime[num];
            map.put(p, map.getOrDefault(p, 0) + 1);
            num /= p;
        }
        return map;
    }

    // Modular inverse using Fermat's Little Theorem
    private long modInverse(long a) {
        return modPow(a, MOD - 2);
    }

    private long modPow(long base, long exp) {
        long result = 1;
        while (exp > 0) {
            if ((exp & 1) == 1)
                result = (result * base) % MOD;
            base = (base * base) % MOD;
            exp >>= 1;
        }
        return result;
    }

    public static void main(String[] args) {
        
    }
}