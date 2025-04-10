import java.util.Arrays;

class Leetcode494{

    private static int sum = 0;

    public int findTargetSumWays(int[] nums, int target) {
        for(int i : nums){
            sum += i;
        }

        int[][] dp = new int[nums.length][2*sum + 1];
        
        for(int[] arr : dp){
            Arrays.fill(arr,-1);
        }
        return helper(nums, 0, target, dp);
    }

    static int helper(int[] nums,int i,int target,int[][] dp){
        if(i == nums.length){
            if(target == 0)return 1;
            else return 0;
        }

        int ttemp = target;
        if(ttemp < 0)ttemp = Math.abs(ttemp);
        if(dp[i][ttemp] != -1)return dp[i][ttemp];

        int add = helper(nums, i+1, target-nums[i], dp);
        int sub = helper(nums, i+1, target+nums[i], dp);
        return dp[i][ttemp] = add+sub;
    }



    // hashmap solution

    // public int findTargetSumWays(int[] nums, int target) {
    //     HashMap<String, Integer> dp = new HashMap<>();
    //     return helper(nums, 0, target, dp);
    // }

    // // Recursive helper function with memoization
    // static int helper(int[] nums, int i, int target, HashMap<String, Integer> dp) {
    //     // Base case: If we reached the end of array
    //     if (i == nums.length) {
    //         return target == 0 ? 1 : 0;
    //     }

    //     // Generate a unique key based on index and current target
    //     String key = i + "," + target;

    //     // Check if result is already computed
    //     if (dp.containsKey(key)) {
    //         return dp.get(key);
    //     }

    //     // Recur for both adding and subtracting the current number
    //     int add = helper(nums, i + 1, target - nums[i], dp);
    //     int sub = helper(nums, i + 1, target + nums[i], dp);

    //     // Store the result in the memoization map
    //     dp.put(key, add + sub);
    //     return add + sub;
    // }


    public static void main(String[] args) {
        
    }
}