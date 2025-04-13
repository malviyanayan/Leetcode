class Leetcode55{

    public boolean canJump(int[] nums) {
        Boolean[] dp = new Boolean[nums.length]; // null means not calculated
        return helper(0, nums, dp);
    }

    private boolean helper(int i, int[] nums, Boolean[] dp) {
        if (i >= nums.length - 1) return true;
        if (dp[i] != null) return dp[i];

        int maxJump = nums[i];
        for (int j = 1; j <= maxJump; j++) {
            if (helper(i + j, nums, dp)) {
                return dp[i] = true;
            }
        }

        return dp[i] = false;
    }



    // Greedy
    public boolean canJump2(int[] nums) {
        int reach = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > reach) return false;
            reach = Math.max(reach, i + nums[i]);
        }
        return true;
    }
    


    public static void main(String[] args){

    }
}