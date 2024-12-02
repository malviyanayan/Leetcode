import java.util.Arrays;

class Leetcode746 {
    public static void main(String[] args) {
        // int[] arr = {10,15,20};
        int[] arr = {1,100,1,1,1,100,1,1,100,1};
        System.out.println(minCostClimbingStairs(arr));
    }   
    
    static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        return Math.min(helper(cost,n-1,dp),helper(cost,n-2,dp));
    }

    private static int helper(int[] cost,int idx,int[] dp){
        if(idx<=1)return cost[idx];
        if(dp[idx] != -1)return dp[idx];
        int ans = cost[idx] + Math.min(helper(cost, idx-1,dp),helper(cost, idx-2,dp));
        dp[idx] = ans;
        return ans;
    }
}
