import java.util.Arrays;

class Leetcode416 {

        public boolean canPartition(int[] nums) {
        int total = 0;
        for (int num : nums) total += num;

        // If total sum is odd, we can't split it into two equal parts
        if (total % 2 != 0) return false;

        int target = total / 2;
        int n = nums.length;

        // Initialize DP array with -1
        int[][] dp = new int[n][target + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        // Start recursion
        return helper(nums, 0, 0, target, dp);
    }

    static boolean helper(int[] nums, int index, int currSum, int target, int[][] dp) {
        // If current sum equals target, we've found a valid subset
        if (currSum == target) return true;

        // If index is out of bounds or sum exceeds target
        if (index == nums.length || currSum > target) return false;

        // If already computed, return stored result
        if (dp[index][currSum] != -1) {
            return dp[index][currSum] == 1;
        }

        // Include current number
        boolean take = helper(nums, index + 1, currSum + nums[index], target, dp);

        // Exclude current number
        boolean skip = helper(nums, index + 1, currSum, target, dp);

        // Store the result
        dp[index][currSum] = (take || skip) ? 1 : 0;
        return take || skip;
    }

    public static void main(String[] args) {
        Leetcode416 obj = new Leetcode416();
        int[] nums = {1, 5, 11, 5};
        System.out.println(obj.canPartition(nums));  // true
    }
}
