import java.util.Arrays;

class Leetcode1312{

    public int minInsertions(String s) {
        int[][] dp = new int[s.length() + 1][s.length() + 1];
        for (int[] next : dp) {
            Arrays.fill(next, -1);
        }
        return helper(0, s.length() - 1, s, dp);
    }

    static int helper(int i, int j, String s, int[][] dp) {
        if (i == j)
            return 1;
        if (i > j)
            return 0;
        // if same so we can

        if (dp[i][j] != -1)
            return dp[i][j];
        int ans;
        if (s.charAt(i) == s.charAt(j)) {
            ans = 2 + helper(i + 1, j - 1, s, dp);
        } else {
            // else find other possibilities

            // left
            int left = helper(i + 1, j, s, dp);

            // right
            int right = helper(i, j - 1, s, dp);

            ans = Math.max(left, right);
        }

        return dp[i][j] = ans;
    }



    // ---------
    public int minInsertions1(String s) {
        return s.length() - longestPalindromeSubseq(s);
    }

    public int longestPalindromeSubseq(String s) {
        return longestCommonSubsequence(s, reverse(s));
    }

    static String reverse(String s){
        StringBuilder sb = new StringBuilder();
        for(int i=s.length()-1;i >= 0;i--){
            sb.append(s.charAt(i));
        }

        return sb.toString();
    }

    public int longestCommonSubsequence(String a, String b) {
        int m = a.length();
        int n = b.length();
        
        int[][] dp = new int[2][n+1];

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(a.charAt(i-1) == b.charAt(j-1)){
                    dp[1][j] = 1 + dp[0][j-1];
                }else{
                    dp[1][j] = Math.max(dp[1][j-1] , dp[0][j]);
                }
            }

            for(int j=0;j<n+1;j++)
                dp[0][j] = dp[1][j];
        }

        return dp[1][n];
    }


    public static void main(String[] args){

    }
}