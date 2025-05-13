class Leetcode3335{
    private static final int MOD = 1_000_000_007;

    public int lengthAfterTransformations(String s, int t) {
        long[] count = new long[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        for (int step = 0; step < t; step++) {
            long[] next = new long[26];
            for (int i = 0; i < 25; i++) {
                next[i + 1] = count[i];
            }
            // 'z' → 'a' and 'b'
            next[0] = (next[0] + count[25]) % MOD;
            next[1] = (next[1] + count[25]) % MOD;
            count = next;
        }

        long total = 0;
        for (long c : count) {
            total = (total + c) % MOD;
        }
        return (int) total;
    }

    public static void main(String[] args){
        Leetcode3335 obj = new Leetcode3335();
        String s = "abc";
        int t = 2;
        int result = obj.lengthAfterTransformations(s, t);
        System.out.println(result); // Output: 6
    }
}