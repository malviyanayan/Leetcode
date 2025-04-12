import java.util.Arrays;

class Leetcode322 {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int result = helper(coins, 0, amount, dp);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    // Returns minimum number of coins needed to form 'amount' using coins[i...n]
    private static int helper(int[] coins, int i, int amount, int[][] dp) {
        if (amount == 0)
            return 0; // no coins needed
        if (amount < 0 || i == coins.length)
            return Integer.MAX_VALUE; // invalid case

        if (dp[i][amount] != -1)
            return dp[i][amount];

        // skip current coin
        int skip = helper(coins, i + 1, amount, dp);

        // take current coin
        int take = helper(coins, i, amount - coins[i], dp);

        if (take != Integer.MAX_VALUE)
            take += 1; // if take path is valid, add 1 coin

        dp[i][amount] = Math.min(skip, take);
        return dp[i][amount];
    }

    // Tabulation
    public int coinChange1(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
    
        // Initialize: 0 coins needed to make amount 0
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
    
        // Initialize the rest with a large value
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                dp[i][j] = Integer.MAX_VALUE - 1; // To avoid overflow
            }
        }
    
        // Fill DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                int skip = dp[i - 1][j];
                int take = Integer.MAX_VALUE - 1;
    
                if (j >= coins[i - 1]) {
                    take = dp[i][j - coins[i - 1]] + 1;
                }
    
                dp[i][j] = Math.min(skip, take);
            }
        }
    
        return dp[n][amount] == Integer.MAX_VALUE - 1 ? -1 : dp[n][amount];
    }
    
    public static void main(String[] args) {
        // int[] coins = { 1, 2, 5 };
        // int amount = 11;
        // System.out.println(helper(coins, 0, 0, amount));
    }

}
