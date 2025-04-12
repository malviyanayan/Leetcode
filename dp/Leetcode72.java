import java.util.Arrays;

class Leetcode72 {
    public int minDistance(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for(int[] next : dp){
            Arrays.fill(next,-1);
        }
        return helper(s1, s2, s1.length(), s2.length(), dp);
    }

    private int helper(String s1, String s2, int i, int j, int[][] dp) {
        // If s1 is empty, we need to insert all characters of s2
        if (i == 0) return j;

        // If s2 is empty, we need to delete all characters of s1
        if (j == 0) return i;

        if(dp[i][j] != -1)return dp[i][j];
        // If characters match, move to the next
        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
            return helper(s1, s2, i - 1, j - 1, dp);
        } else {
            // Else try all three operations and take the minimum
            int insertOp = helper(s1, s2, i, j - 1, dp);      // insert
            int deleteOp = helper(s1, s2, i - 1, j, dp);      // delete
            int replaceOp = helper(s1, s2, i - 1, j - 1, dp); // replace

            return dp[i][j] = 1 + Math.min(insertOp, Math.min(deleteOp, replaceOp));
        }
        
    }


    // Tabulation
    public int minDistance1(String s1, String s2) {
        int m = s1.length() + 1,n = s2.length() + 1;
        int[][] dp = new int[m][n];

        for(int i=1;i <= m;i++){
            for(int j=1;j <= n;j++){
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    // Else try all three operations and take the minimum
                    int insertOp = dp[i][j-1];
                    int deleteOp = dp[i-1][j];
                    int replaceOp = dp[i-1][j-1];
        
                    dp[i][j] = 1 + Math.min(insertOp, Math.min(deleteOp, replaceOp));
                }
            }
        }


        return dp[m][n];
    }
}
