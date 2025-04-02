import java.util.Arrays;

class Leetcode45 {
    static int jump(int[] nums) {
        int[] temp = new int[nums.length];
        Arrays.fill(temp, -1);
        return helper(nums, 0, temp);
    }    

    static int helper(int[] nums, int i, int[] temp) {
        if (i == nums.length - 1) return 0;  // Reached last index, no more jumps needed
        
        if (temp[i] != -1) return temp[i];   // Use memoized result

        int minJumps = Integer.MAX_VALUE;
        int maxSteps = nums[i]; // Number of steps we can take

        for (int j = 1; j <= maxSteps; j++) {
            if (i + j < nums.length) {
                int jumps = helper(nums, i + j, temp);
                
                if (jumps != Integer.MAX_VALUE) { // Ensure we are not adding to MAX_VALUE
                    minJumps = Math.min(minJumps, 1 + jumps);
                }
            }
        }

        temp[i] = minJumps;  // Store computed result
        return minJumps;
    }

}
