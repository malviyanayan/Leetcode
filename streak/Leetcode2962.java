class Leetcode2962 {
    public long countSubarrays(int[] nums, int k) {
        int max = Integer.MIN_VALUE;

        // Step 1: Find the maximum value in the array
        for (int num : nums) {
            max = Math.max(max, num);
        }

        int left = 0;
        int count = 0;
        long result = 0;

        // Step 2: Sliding window
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == max) {
                count++;
            }

            while (count >= k) {
                if (nums[left] == max) {
                    count--;
                }
                left++;
            }

            result += left;
        }

        return result;
    }    
}
