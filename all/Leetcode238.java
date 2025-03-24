class Leetcode238 {
    public static void main(String[] args) {
        // int[] arr = {1,2,3,4};
        int[] arr = {-1,1,0,-3,3};
        arr = productExceptSelf(arr);
        System.out.print("Array is : ");
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i] + ", ");
        }
    }

    // static int[] productExceptSelf(int[] nums) {
    //     int[] prefix = new int[nums.length];
    //     int preMult = 1;
    //     prefix[0] = preMult;
    //     for(int i=1;i<nums.length;i++){
    //         preMult *= nums[i-1];
    //         prefix[i] = preMult;
    //     }

    //     int[] suffix = new int[nums.length];
    //     preMult = 1;
    //     suffix[nums.length-1] = preMult;
    //     for(int i = nums.length-2;i>=0;i--){
    //         preMult *= nums[i+1];
    //         suffix[i] = preMult;
    //     }

    //     for(int i=0;i<nums.length;i++){
    //         nums[i] = prefix[i] * suffix[i];
    //     }

    //     return nums;
    // }

    static int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        int preMult = 1;
        prefix[0] = preMult;
        for(int i=1;i<nums.length;i++){
            preMult *= nums[i-1];
            prefix[i] = preMult;
        }

        int[] suffix = new int[nums.length];
        preMult = 1;
        suffix[nums.length-1] = preMult;
        for(int i = nums.length-2;i>=0;i--){
            preMult *= nums[i+1];
            suffix[i] = preMult;
        }

        for(int i=0;i<nums.length;i++){
            nums[i] = prefix[i] * suffix[i];
        }
      return null;  
    }
}
