import java.util.Arrays;

class Leetcode338 {

    public int[] countBits(int n) {
        int[] ans = new int[n+1];

        for(int i=0;i<=n;i++){
            String str = Integer.toString(i,2);
            int count = 0;
            for(int j = 0;j<str.length();j++)if(str.charAt(j) == '1')count++;
            ans[i] = count;
        }

        return ans;
    }

    public int[] countBits2(int n) {
        int[] dp = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
            // dp[i >> 1] is the count for i/2
            // (i & 1) adds 1 if the last bit is 1 (i is odd), else 0
            dp[i] = dp[i >> 1] + (i & 1);
        }
        
        return dp;
    }
    

    public int[] countBits1(int n) {
        if(n == 0)return new int[]{0};
        else if(n == 1)return new int[]{0, 1};
        
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;

        int next = 0;

        for(int i=2;i<=n;i++){
            if((i & i-1) == 0){
                next++;
                dp[i] = 1;
            }else{
                int temp = i - (int)Math.pow(2, next);
                dp[i] = 1 + dp[temp];
            }
        }

        return dp;
    }



    public static void main(String[] args) {
        System.out.println(7 >> 1);
    }    
}
