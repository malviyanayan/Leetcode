import java.util.Arrays;

class Leetcode583{


    public int minDistance1(String word1, String word2) {
        int[][] dp = new int[word1.length()][word2.length()];
        for(int[] next : dp)Arrays.fill(next, -1);
        return helper(word1.length()-1, word2.length()-1, word1, word2, dp)+1;
    }

    static int helper(int i,int j,String a, String b, int[][] dp){
        if(i < 0)return j;
        if(j < 0)return i;


        if(dp[i][j] != -1)return dp[i][j];

        if(a.charAt(i) == b.charAt(j)){
            return helper(i-1, j-1, a, b, dp);
        }else{
            int aLeft = 1+helper(i-1, j, a, b, dp);
            int bLeft = 1+helper(i, j-1, a, b, dp);

            return dp[i][j] = Math.min(aLeft, bLeft);
        }
    }


    // ----------------
    public int minDistance(String word1, String word2) {
        return (word1.length() - lcs(word1,word2)) + (word2.length() - lcs(word2,word1));
    }

    public int lcs(String a, String b) {
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

}