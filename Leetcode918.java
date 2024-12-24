class Leetcode918{
    public static void main(String[] args) {
        int[] nums = {1,-2,3,-2};
        System.out.println(maxSubarraySumCircular(nums));
        // System.out.println(maxSum(0, nums));
    }

    static int maxSubarraySumCircular(int[] nums) {
        int global = nums[0];
        int current = nums[0];
        
        for(int i=1;i<nums.length;i++){
            current = Math.max(nums[0],nums[0]+current);
            global = Math.max(global,current);
        }

        return global;
    }

    



}