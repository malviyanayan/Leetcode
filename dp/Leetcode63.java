class Leetcode63 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[0][0] == 1 || obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1] == 1)return 0;
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        return helper(obstacleGrid.length - 1,obstacleGrid[0].length - 1,obstacleGrid,dp);
    }

    static int helper(int m, int n,int[][] grid,int[][] dp){
        if(m == 0 && n == 0)return 1;
        else if(m < 0 || n < 0)return 0;
        else if(grid[m][n] == 1)return 0;

        if(dp[m][n] != 0)return dp[m][n];

        return dp[m][n] = helper(m - 1, n, grid, dp) + helper(m, n - 1, grid, dp);
    }

    public static void main(String[] args){
        
    }    
}
