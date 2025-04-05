class Leetcode64 {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        helper(0 , 0 , grid, dp);
        return dp[0][0];
    }

    static int helper(int i, int j, int grid[][],int[][] dp){
        if(i == grid.length || j == grid[0].length)return 0;
        else if(i == grid.length - 1 || j == grid[0].length - 1)return grid[i][j];

        if(dp[i][j] != 0)return dp[i][j];

        int right = helper(i, j + 1, grid, dp);
        int down = helper(i + 1, j, grid, dp);

        return dp[i][j] = grid[i][j] + Math.min(right,down);
    }
    
    public static void main(String[] args) {
        
    }
}
