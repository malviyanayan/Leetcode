class Leetcode509{
    public static void main(String[] args){
        int n = 6;
        System.out.println(fib(n));
    }

    static int[] dp;

    static int fib(int n) {
        dp = new int[n+1];
        return fibo(n);
    }


    static int fibo(int n){
        if(n<=1)return n;
        if(dp[n] != 0)return dp[n];
        int ans = fibo(n-1)+ fibo(n-2);
        dp[n] = ans;
        return ans;
    }

}