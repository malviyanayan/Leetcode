// Two Sum
import java.util.HashMap;

class Leetcode1 {
    public static void main(String[] args) {

        // int[] arr = {2,7,11,15};int target  = 9;
        int[] arr = {-3,4,3,90};int target  = 0;

        int[] arr1 = twoSum(arr,target);
        System.out.println("Two sum is : " + arr1[0] + " , " + arr1[1]);
    }

    static int[] twoSum(int[] nums, int target) {
        int[] ans = {-1, -1};
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<nums.length;i++){
                if(map.containsKey(target-nums[i])){
                    ans[0] = map.get(target-nums[i]);
                    ans[1] = i;
                    return ans;
                }else{
                    map.put(nums[i], i);
                }
        }

        return ans;
    }
}
