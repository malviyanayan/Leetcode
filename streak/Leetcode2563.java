import java.util.Arrays;

class Leetcode2563 {

    // time limit exceed ganda solution hai ye
    static long countFairPairs(int[] nums, int lower, int upper) {
        long count = 0;
        Arrays.sort(nums);
        
        for(int i=0;i<nums.length-1;i++)
            for(int j=i+1;j<nums.length;j++)
                if(nums[i] + nums[j] >= lower && nums[i] + nums[j] <= upper)count++;
            
        return count;
    }    


}
