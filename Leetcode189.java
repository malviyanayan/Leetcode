public class Leetcode189{
    public static void main(String[] args) {
        // int[] nums = {1,2,3,4,5,6,7};
        // int k = 3;
        int[] nums = {-1,-100,3,99};
        int k = 2;

        rotate(nums, k);

        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i] + ", ");
        }
    }


    // this is simple code by me 
    static void rotate(int[] nums, int k) {
        k = k % nums.length;
        int[] temp = new int[k];
        int j = 0;
        for(int i = nums.length - k;i<nums.length;i++){
            temp[j++] = nums[i];
        }

        j = nums.length - k - 1;
        for(int i = nums.length - 1;j >= 0;i--){
            nums[i] = nums[j];
            j--;
        }

        for(int i=0;i<temp.length;i++){
            nums[i] = temp[i];
        }
    }

    // this is optimize version of my code
    static void rotate1(int[] nums,int k){
        k = k % nums.length;

        // reverse all array
        reverse(nums, 0, nums.length);

        // reverse first part
        reverse(nums, 0, k-1);

        // reverse second part
        reverse(nums, k, nums.length);

        // now your array is rotate successfully


    }

    private static void reverse(int[] nums,int s,int e){
        while(s<e){
            int temp = nums[s];
            nums[s] = nums[e];
            nums[e] = temp;
            s++;
            e--;
        }
    }
}