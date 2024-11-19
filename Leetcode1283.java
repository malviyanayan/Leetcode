// Find the Smallest Divisor Given a Threshold

class Leetcode1283 {
    public static void main(String[] args) {
        // int[] arr = {1,2,5,9};
        // int t = 6;
        // int[] arr = {44,22,33,11,1};
        // int t = 5;
        // int[] arr = {1, 1, 1, 1, 1};
        // int t = 5;
        // int[] arr = {1, 2, 3, 4, 5};
        // int t = 10;
        int[] arr = {10, 20, 30};
        int t = 6;
        // int[] arr = {1, 100, 1000};
        // int t = 15;
        // int[] arr = {10, 20, 30};
        // int t = 100;
        // int[] arr = { 50 };
        // int t = 5;
        // System.out.println(10%11);

        System.out.println(smallestDivisor(arr, t));
    }

    // static int smallestDivisor(int[] nums, int threshold) {
    //     int max = Integer.MIN_VALUE;
    //     for(int i=0;i<nums.length;i++){
    //         if(nums[i]>max)max = nums[i];
    //     }
    // int ans = -1;

    // for(int i=1;i<=max;i++){
    // int sum = 0;
    // for(int j = 0;j<nums.length;j++){
    // if(nums[j]%i!=0)sum++;
    // sum+=(nums[j]/i);
    // }
    // if(sum<=threshold){
    // ans = i;
    // break;
    // }
    // }

    // return ans;
    // }

    static int smallestDivisor(int[] nums, int threshold) {

        int max = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>max)max = nums[i];
        }
        
        int ans = nums.length;
        int s = 1;

        while (s <= max) {
            int mid = max - (max - s) / 2;

            int sum = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] % mid != 0)
                    sum++;
                sum += (nums[j] / mid);
            }

            if(sum<=threshold){
                ans = mid;
                max = mid-1;
            }else s = mid + 1;
        }

        return ans;
    }

}
