import java.util.Arrays;

class Leetcode198 {

    // ############ memoization code start -------
    public int rob(int[] nums) {
        int[] dp = new int[nums.length + 1];
        Arrays.fill(dp,-1);
        return helper(0, nums, dp);
    }

    static int helper(int i,int[] nums,int[] dp){
        if(i >= nums.length)return 0;
        if(dp[i] != -1)return dp[i];
        return dp[i] = Math.max(nums[i] + helper(i+2,nums, dp),helper(i+1, nums, dp));
    }
    // ############ memoization code end -------


    // ############ Tabulation code start -------
    static int rob1(int[] nums) {
        if(nums.length == 1)return nums[0];
        else if(nums.length == 2)return Math.max(nums[0],nums[1]);

        int[] dp = new int[nums.length + 1];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for(int i=2;i<nums.length;i++){
            dp[i] = Math.max(nums[i]+dp[i-2], dp[i-1]);
            System.out.println(dp[i] + "---");
        }
        
        return dp[nums.length - 1];
    }
    
    public static void main(String[] args){
        int[] arr = {2,1,1,2};
        System.out.println(rob1(arr));
    }
}
