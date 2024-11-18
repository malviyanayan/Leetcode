class Leetcode3355 {
    public static void main(String[] args) {
        // int[][] queries = {{1,3},{0,2}};
        // int[] nums = {4,3,2,1};
        // int[][] queries = {{0,2}};
        // int[] nums = {1,0,1};
        int[][] queries = {};
        int[] nums = {};
        System.out.println(isZeroArray(nums, queries));
    }

    // static boolean isZeroArray(int[] nums, int[][] queries) {
    // // for(int i=0;i<queries.length;i++){
    // // int s = queries[i][0],e = queries[i][1];
    // // while(s<=e){
    // // if(nums[s]!=0)nums[s]--;

    // // s++;
    // // }
    // // }

    // for (int i = 0; i < queries.length; i++) {
    // int start = queries[i][0];
    // int end = queries[i][1];

    // // Process all indices in the range [start, end]
    // for (int j = start; j <= end; j++) {
    // if (nums[j] > 0) {
    // nums[j]--; // Decrement only if non-zero
    // }
    // }
    // }

    // for(int i=0;i<nums.length;i++){
    // if(nums[i]!=0)return false;
    // }

    // return true;
    // }

    static boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] delta = new int[n + 1]; //

        for (int[] query : queries) {
            int start = query[0];
            int end = query[1];
            delta[start]--;
            if (end + 1 < n) {
                delta[end + 1]++;
            }
        }

        int currentDecrement = 0;
        for (int i = 0; i < n; i++) {
            currentDecrement += delta[i];
            nums[i] += currentDecrement;
            if (nums[i] < 0) {
                return false;
            }
        }

        for (int num : nums) {
            if (num != 0) {
                return false;
            }
        }

        return true;
    }

}