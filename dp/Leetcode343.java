import java.util.Arrays;

class Leetcode343 {
    static int integerBreak(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return helper(n, dp);
    }

    public static int integerBreak3(int n) {
        if (n <= 3) return n - 1;

        int product = 1;
        while (n > 4) {
            product *= 3;
            n -= 3;
        }

        return product * n;
    }

    public static int integerBreak2(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                // Break i into j + (i-j), and choose max of:
                // j * (i-j) → no further split
                // j * dp[i-j] → further split (i-j)
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }

        return dp[n];
    }

    static int helper(int n, int[] dp){
        if(n == 2)return 1;
        if(dp[n] != -1)return dp[n];

        int temp = n/2;
        int max = Integer.MIN_VALUE;
 
        for(int i=1;i<=temp;i++){
            max = Math.max(Math.max(i*(n-i), max), i*helper(n-i, dp));
        }

        return dp[n] = max;
    }


    // simple recursion

    static int helper1(int n){
        if(n == 2)return 1;

        int temp = n/2;
        int max = Integer.MIN_VALUE;
 
        for(int i=1;i<=temp;i++){
            max = Math.max(Math.max(i*(n-i), max), i*helper1(n-i));
        }


        return max;
    }

    

    

    public static void main(String[] args){
        System.out.println(integerBreak(10));

        
    }
}
