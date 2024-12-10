import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Leetcode229{
    public static void main(String[] args){
        // int[] arr = {3,2,3};
        int[] arr = {1};
        // int[] arr = {1,2};
        System.out.println(majorityElement1(arr));
    }


    // First Version
    static List<Integer> majorityElement(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        int n = nums.length;

        ArrayList<Integer> list = new ArrayList<>();
        for(Integer key : map.keySet()){
            if(map.get(key)>(n/3))list.add(key);
        }
        return list;
    }


    // Second Version
    static List<Integer> majorityElement1(int[] nums) {
        Arrays.sort(nums);
        int k = nums.length/3;


        ArrayList<Integer> ans = new ArrayList<>();
        int num = nums[0];
        int count = 1;

        for(int i = 1;i<nums.length;i++){
            if(nums[i]==num)count++;
            else{
                if(count>k)ans.add(num);
                count = 1;
                num = nums[i];
            }
        }

        if(count>k)ans.add(num);
        return ans;
    }
}