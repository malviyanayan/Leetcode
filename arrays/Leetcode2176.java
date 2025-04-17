import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Leetcode2176{

    public int countPairs(int[] nums, int k) {
        int count = 0;

        for(int i=0;i<nums.length-1;i++)
            for(int j = i+1;j<nums.length;j++)
                if(nums[i] == nums[j] && (i*j)%k == 0)count++;
            

        return count;
    }


    
    public int countPairs1(int[] nums, int k) {
        int count = 0;
        Map<Integer, List<Integer>> valueIndicesMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            valueIndicesMap.putIfAbsent(nums[i], new ArrayList<>());
            for (int index : valueIndicesMap.get(nums[i])) {
                if ((index * i) % k == 0) {
                    count++;
                }
            }
            valueIndicesMap.get(nums[i]).add(i);
        }

        return count;
    }


    public static void main(String[] args){
        
    }

}