import java.util.HashSet;

class Leetcode2461{
    static long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long[] arr = new long[n-k+1];

        for(int i=0;i<n-k+1;i++){
            long ttemp = 0;
            HashSet<Integer> set = new HashSet<>();
            boolean flag = true;

            for(int j = i;j<=i+k-1;j++){
                if(set.contains(nums[j])){
                    System.out.println(i + "------");
                    flag = false;
                    break;
                }
                else{
                    set.add(nums[j]);
                    ttemp = ttemp + nums[j];
                }
            }
            if(flag)arr[i] = ttemp;
        }


        long ans = 0;
        for(long temp : arr){
            System.out.println(temp + "#######");
            if(ans<temp)ans = temp;
        }

        return ans;
    }

    public static void main(String[] args){
        int[] temp = {1,5,4,2,9,9,9};
        System.out.println(maximumSubarraySum(temp, 3));
    }
}