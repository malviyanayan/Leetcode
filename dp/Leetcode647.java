class Leetcode647 {
    public static int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int count = 0;

        for (int gap = 0; gap < n; gap++) {
            for (int i = 0, j = gap; j < n; i++, j++) {
                if (gap == 0) {
                    dp[i][j] = true; // single char
                } else if (gap == 1) {
                    dp[i][j] = (s.charAt(i) == s.charAt(j)); // two chars
                } else {
                    dp[i][j] = (s.charAt(i) == s.charAt(j)) && dp[i+1][j-1]; // more than 2
                }

                if (dp[i][j]) count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(countSubstrings("abc"));    // 3
        System.out.println(countSubstrings("aaa"));    // 6
        System.out.println(countSubstrings("aabaa"));  // 9
    }
}
