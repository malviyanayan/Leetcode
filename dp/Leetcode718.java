import java.util.Arrays;

class Leetcode718 {

    public int findLength1(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[][] dp = new int[n + 1][m + 1]; // dp[i][j] = length of longest common suffix of nums1[0..i-1] and nums2[0..j-1]
        int maxLen = 0;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (nums1[i] == nums2[j]) {
                    dp[i][j] = dp[i + 1][j + 1] + 1;
                    maxLen = Math.max(maxLen, dp[i][j]);
                }
            }
        }

        return maxLen;
    }

    static int findLength(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        // Using -1 as initial value to indicate uncomputed state
        int[][][] dp = new int[n + 1][m + 1][Math.min(n, m) + 1];
        for (int[][] a : dp)
            for (int[] b : a)
                Arrays.fill(b, -1);

        return helper(0, 0, 0, nums1, nums2, dp);
    }

    static int helper(int i, int j, int count, int[] nums1, int[] nums2, int[][][] dp) {
        if (i == nums1.length || j == nums2.length)
            return count;

        if (dp[i][j][count] != -1)
            return dp[i][j][count];

        int currCount = count;
        if (nums1[i] == nums2[j]) {
            currCount = helper(i + 1, j + 1, count + 1, nums1, nums2, dp);
        }

        int moveI = helper(i + 1, j, 0, nums1, nums2, dp);
        int moveJ = helper(i, j + 1, 0, nums1, nums2, dp);

        dp[i][j][count] = Math.max(currCount, Math.max(moveI, moveJ));
        return dp[i][j][count];
    }

    public static void main(String[] args) {
        System.out.println(findLength(new int[]{0, 1, 1}, new int[]{1, 0, 1}));
    }
}
