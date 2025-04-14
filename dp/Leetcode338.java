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

    public int[] countBits1(int n) {
        if(n == 0)return new int[]{0};
        else if(n == 1)return new int[]{0, 1};
        else if(n == 2)return new int[]{0, 1, 1};
        
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;

        for(int i=3;i<=n;i++){
            int temp = (int)Math.sqrt(i);
            if(temp*temp == i)dp[i] = 1;
            else dp[i] = 1 + dp[i - temp];
        }

        return dp;
    }



    public static void main(String[] args) {
        
    }    
}
