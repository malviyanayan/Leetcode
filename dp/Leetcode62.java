class Leetcode62{
    
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        return helper(0, 0, m, n, dp);
    }

    static int helper(int c1, int c2, int m, int n,int[][] dp){
        if(c1 == m-1 && c2 == n-1)return 1;

        if(dp[c1][c2] != 0)return dp[c1][c2];
        // go right
        if(c1 != m-1){
            dp[c1][c2] = helper(c1+1, c2, m, n, dp);
        }

        if(c2 != n-1){
            dp[c1][c2] += helper(c1, c2+1, m, n, dp);
        }

        return dp[c1][c2]; 
    }

    public static void main(String[] args) {
        
    }
}