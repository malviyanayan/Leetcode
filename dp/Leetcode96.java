class Leetcode96{

    public int numTrees1(int n) {
        if(n <= 2)return n;
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;

        for(int i=2;i<n;i++){
            dp[i] = dp[i-1]*dp[i-2];
        }
        return dp[n-2];
    }

    public int numTrees(int n) {
        if(n == 0)return 0;
        if(n == 1)return 1;

        int total = 0;
        for(int i=1;i<=n;i++){
            total = numTrees(i-1) + numTrees(n-i);
        }

        return total;
    }

    
    public static void main(String[] args){

    }
}