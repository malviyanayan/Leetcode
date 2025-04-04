class Leetcode213{

    public int rob(int[] nums) {
        if(nums.length  <= 1)return nums[0];

        boolean flag = false;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        if(nums[0] > nums[1]){
            flag = true;
            dp[1] = nums[0];
        }else{
            dp[1] = nums[1];
        }

        for(int i=2;i<nums.length;i++){
            // take current 
            if(nums[i]+dp[i-2] > dp[i-1]){
                if(i-2 == 0)flag = true;
                dp[i] = nums[i] + dp[i-2];
            }else{
                // ignore current
                dp[i] = dp[i-1];
            }
        }

        return dp[nums.length - 1];
    }
    

    public int rob1(int[] nums) {
        return helper(nums, 0,false);
    }

    static int helper(int[] nums,int i,boolean flag){
        if(i>=nums.length)return 0;

        // take
        int take = 0;
        if(i==0)take = nums[i] + helper(nums, i, true);
        else take = nums[i] + helper(nums, i+2,flag);
        // skip
        int skip = helper(nums, i+1,flag);
        return Math.max(take, skip);
    }
    
    public static void main(String[] args){

    }
}