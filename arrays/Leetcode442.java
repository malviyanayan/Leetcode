import java.util.ArrayList;
import java.util.List;

class Leetcode442 {

    // Method - 1 o(n^2) -> Bruete Force

    // Method - 2 (HashMap wali) jisme key pairs ko store karenge tc-o(n),sc-o(n)

    // Method - 3 using index because 1 <= nums[i] <= n
    static List<Integer> findDuplicates(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0;i<nums.length;i++){
            int temp = Math.abs(nums[i]);
            // check index is visited
            if(nums[temp-1] < 0)list.add(temp);
            
            // mark index is visited
            int temp1 = nums[temp - 1];
            nums[temp - 1] = -temp1;
        }

        return list;
    }

    public static void main(String[] args) {
        int[] arr = {4,3,2,7,8,2,3,1};
        List<Integer> list = findDuplicates(arr);
        System.out.println(list);
    }    
}
