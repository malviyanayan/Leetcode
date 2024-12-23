class Leetcode918{
    public static void main(String[] args) {
        int[] nums = {1,-2,3,-2};
        System.out.println(maxSubarraySumCircular(nums));
        // System.out.println(maxSum(0, nums));
    }

    static int maxSubarraySumCircular(int[] nums) {
        int[] temp = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            temp[i] = maxSum(i,nums);
        }

        int max = Integer.MIN_VALUE;
        for(int i=0;i<temp.length;i++){
            if(temp[i]>max)max = temp[i];
        }
        return max;
    }

    private static int maxSum(int x,int[] nums){
        int l = nums.length;
        int max = nums[x];
        for(int i=x+1;i<l;i++){
            if(nums[i]+max > max)max = nums[i] + max;
        }

        for(int i=0;i<x;i++){
            if(nums[i]+max > max)max = nums[i] + max;
        }

        return max;
    }



}