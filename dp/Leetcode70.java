import java.util.Arrays;

// Climbing stairs
/*
 * You are climbing a staircase. It takes n steps to reach the top.
 *  Each time you can either climb 1 or 2 steps.
 *  In how many distinct ways can you climb to the top?
 */

/*Example
 * Input: n = 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * Example 2:
 */
class Leetcode70 {

    // -------------- # Date 24/10/2025 # -------------
    
    // -------------- # Date 24/10/2025 # -------------





    public int climbStairs(int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return helper(0, n, dp);
    }

    static int helper(int i, int n, int[] dp) {
        if (i == n)
            return 1;
        else if (i > n)
            return 0;

        if (dp[i] != -1)
            return dp[i];

        return dp[i] = helper(i + 1, n, dp) + helper(i + 2, n, dp);
    }

    public int climbStairs1(int n) {
        if (n <= 2)
            return n;

        int prev2 = 1;
        int prev1 = 2;

        for (int i = 3; i <= n; i++) {
            int curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }

    public static void main(String[] args) {

    }
}