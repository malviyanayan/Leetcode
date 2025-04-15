import java.util.Arrays;

class Leetcode413{

    static int numberOfArithmeticSlices1(int[] nums) {
        if (nums.length < 3) return 0;
        
        int
        
        count = 0;
        int curr = 0;
    
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                curr++;           // Extend the previous slice
                count += curr;    // Add all slices ending at i
            } else {
                curr = 0;         // Reset if difference breaks
            }
        }
    
        return count;
    }

    static int numberOfArithmeticSlices(int[] nums) {
        int[][] dp = new int[nums.length+1][nums.length+1];
        for(int[] next : dp)Arrays.fill(next, -1);

        return helper(nums, 0, nums.length-1, dp);
    }

    static int helper(int[] arr, int i, int j, int[][] dp){
        if(j - i < 2)return 0;
        else if (j - i == 2)
            return dp[i][j] = (arr[j] - arr[j-1]) == (arr[j-1] - arr[j-2]) ? 1 : 0;
        
        if(dp[i][j] != -1)return dp[i][j];
        
        int ans = 0;
        if(dp[i][j-1] == 1 && arr[j] - arr[j-1] == arr[j-1] - arr[j-2]){
            dp[i][j] = ans = 1;
        }

        ans += helper(arr, i+1, j, dp);
        ans += helper(arr, i, j-1, dp);
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        System.out.println(numberOfArithmeticSlices1(arr));
    }
}