// Count Nice Pairs in an Array

import java.util.HashMap;

class Leetcode1814 {
    public static void main(String[] args) {
        int[] arr = {42,11,1,97};
        System.out.println("count is : " + countNicePairs(arr));
    }   
    
    private static int reverse(int num){
        int temp = 0,rev;
        while(num!=0){
            rev = num%10;
            temp = temp*10 + rev;
            num/=10;
        }
        return temp;
    }

    // By Brute force

    // static int countNicePairs(int[] nums) {
    //     int count = 0;
    //     for(int i=0;i<nums.length;i++){
    //         for(int j=i+1;j<nums.length;j++){
    //             if(nums[i] + reverse(nums[j]) == nums[j] + reverse(nums[i]))count++;
    //         }
    //     }
    //     return count;
    // }

    static int countNicePairs(int[] nums) {
        int count = 0;
        HashMap<Integer,Integer> pairs = new HashMap<>();

        for(int num : nums){
            if(pairs.containsKey(num-reverse(num))){
                count += pairs.get(num-reverse(num));
            }

            pairs.put(num-reverse(num), pairs.getOrDefault(num-reverse(num),0)+1);
        }

        return count;
    }
}
