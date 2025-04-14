import java.util.Arrays;

class Leetcode1137{

    // simple approach
    public int tribonacci(int n) {
       if(n == 0)return n;
       else if(n == 1 || n == 2)return 1;

       int x = 0,y = 1 , z = 1;
       int ans = x+y+z;
       for(int i=3;i<=n;i++){
        ans = x+y+z;
        x = y;
        y = z;
        z = ans;
       }

       return ans;
    }

    public int tribonacci1(int n) {
       int[] dp = new int[n + 1];
       Arrays.fill(dp, -1);
       return helper(n, dp);
    }


    // ek aur method hai jisme 1d array and uspe iterate karke answer de sakte hai 


    // by recursion + memoization
    static int helper(int n, int[] dp){
        if(n <= 0)return 0;
        else if(n == 1 || n == 2)return 1;

        if(dp[n] != -1)return dp[n];
        return dp[n] = helper(n-3, dp) + helper(n-2, dp) + helper(n-1, dp);
    }

    public static void main(String[] args){

    }
}