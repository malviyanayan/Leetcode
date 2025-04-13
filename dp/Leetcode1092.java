// import java.util.Arrays;

class Leetcode1092{

    static String shortestCommonSupersequence(String a, String b) {
        StringBuilder temp = lcs(a, b);
        StringBuilder sb = new StringBuilder();
        int i = 0, j = 0, k = 0;
        while(i < temp.length()){
            char next = temp.charAt(i++);
            while(j != a.length() && a.charAt(j) != next)sb.append(a.charAt(j++));
            while(k != b.length() && b.charAt(k) != next)sb.append(b.charAt(k++));

            j++;
            k++;
            sb.append(next);
        }

        while(j != a.length())
            sb.append(a.charAt(j++));

        while(k != b.length())
            sb.append(b.charAt(k++));

        return sb.toString();
    }

    static StringBuilder lcs(String a, String b) {
        int m = a.length();
        int n = b.length();
        
        int[][] dp = new int[m+1][n+1];

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(a.charAt(i-1) == b.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i][j-1] , dp[i-1][j]);
                }
            }

            for(int j=0;j<n+1;j++)
                dp[0][j] = dp[1][j];
        }


        int i = m, j = n;
        StringBuilder lcs = new StringBuilder();

        while (i > 0 && j > 0) {
            if (a.charAt(i - 1) == b.charAt(j - 1)) {
                lcs.insert(0,a.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }

        return lcs;
    }

    public static void main(String[] args){
        // int[][] dp = new int[4][3];
        // for(int[] next : dp)Arrays.fill(next,-1);
        // System.out.println(lcs("AGGTAB", "GXTXAYB"));
        // System.out.println(shortestCommonSupersequence("AGGTAB", "GXTXAYB"));
        System.out.println(shortestCommonSupersequence("abac", "cab"));
        // System.out.println(helper(3, 2,"AGGTAB", "GXTXAYB", dp));
    }
}