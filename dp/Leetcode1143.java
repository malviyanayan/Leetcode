import java.util.Arrays;
import java.util.HashMap;

class Leetcode1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        for(int[] temp : dp){
            Arrays.fill(temp, -1);
        }
        return helper(text1.length()-1,text2.length()-1,new StringBuilder(text1), new StringBuilder(text2), dp);
    }


    // Tabulation

    public int longestCommonSubsequence2(String a, String b) {
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


    public int longestCommonSubsequence1(String a, String b) {
        int m = a.length();
        int n = b.length();
        
        int[][] dp = new int[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int p = (i >= 1 && j >= 1) ? dp[i-1][j-1] : 0;
                int q = (i >= 1) ? dp[i-1][j] : 0;
                int r = (j >= 1) ? dp[i][j-1] : 0;
                if(a.charAt(i) == b.charAt(j)){
                    dp[i][j] = 1 + p;
                }else{
                    dp[i][j] = Math.max(q , r);
                }
            }
        }
        return dp[m-1][n-1];
    }

    static int helper(int i,int j, StringBuilder a,StringBuilder b,int[][] dp){
        if(i < 0 || j < 0)return 0;
    
        if(dp[i][j] != -1)return dp[i][j];

        int ans = 0;
        if(a.charAt(i) == b.charAt(j)){
            ans = 1 + helper(i -1, j - 1, a, b, dp);
        }else{
            ans = Math.max(helper(i - 1, j, a, b, dp), helper(i, j - 1, a, b, dp));
        }
        return dp[i][j] = ans;
    }

    
    static int helper(int i,int j, StringBuilder a,StringBuilder b, HashMap<String,Integer> dp){
        if(i < 0 || j < 0)return 0;
    
        String temp = i+","+j;
        if(dp.containsKey(temp))return dp.get(temp);

        if(a.charAt(i) == b.charAt(j)){
            return 1 + helper(i -1, j - 1, a, b, dp);
        }else{
            int ans = Math.max(helper(i - 1, j, a, b, dp), helper(i, j - 1, a, b, dp));
            dp.put(temp, ans);
            return ans;
        }
    }

    static int helper1(int i,int j, StringBuilder a,StringBuilder b){
        if(i < 0 || j < 0)return 0;
    
        if(a.charAt(i) == b.charAt(j)){
            return 1 + helper1(i -1, j - 1, a, b);
        }else{
            return Math.max(helper1(i - 1, j, a, b), helper1(i, j - 1, a, b));
        }

    }

    
    static int helper(StringBuilder a,StringBuilder b,HashMap<String,Integer> dp){
        int al = a.length();
        int bl = b.length();

        if(al == 0 || bl == 0)return 0;

        String temp = al+","+bl;
        if(dp.containsKey(temp))return dp.get(temp);

        int ans = 0;
        char temp1 = a.charAt(al-1);a.deleteCharAt(al-1);
        char temp2 = b.charAt(bl-1);b.deleteCharAt(bl-1);

        if(temp1 == temp2){
            ans = 1 + helper(a, b, dp);
            a.append(temp1);
            b.append(temp2);
        }else {
            b.append(temp2);
            int left = helper(a, b, dp);
            a.append(temp1);
            b.deleteCharAt(bl-1);
            int right = helper(a, b, dp);
            b.append(temp2);
            ans = Math.max(left,right);
        }

        dp.put(temp, ans);

        return ans;
    }

}
