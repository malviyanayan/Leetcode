import java.util.Arrays;

class Leetcode70{

    public int climbStairs(int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return helper(0, n, dp);
    }

    static int helper(int i, int n, int[] dp){
        if(i == n)return 1;
        else if(i > n)return 0;

        if(dp[i] != -1)return dp[i];

        return dp[i] = helper(i+1, n, dp) + helper(i+2, n, dp);
    }


    public int climbStairs1(int n) {
        if (n <= 2) return n;
    
        int prev2 = 1;
        int prev1 = 2;
    
        for (int i = 3; i <= n; i++) {
            int curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }
    
        return prev1;
    }
    


    public static void main(String[] args){

    }
}