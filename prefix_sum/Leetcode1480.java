class Leetcode1480{

    public int[] runningSum(int[] nums) {
        for(int i=1;i<nums.length;i++)
            nums[i] = nums[i-1] + nums[i];
        
        return nums;
    }

    public static void main(String[] args) {
        
    }
}