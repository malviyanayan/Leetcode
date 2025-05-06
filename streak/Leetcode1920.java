class Leetcode1920{

    // date 6 may 2025

    public int[] buildArray(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        // Construct the array using the given condition
        for (int i = 0; i < n; i++) {
            ans[i] = nums[nums[i]];
        }

        return ans;
    }

    public static void main(String[] args){
        
    }
}