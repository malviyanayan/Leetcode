import java.util.ArrayList;
import java.util.List;

class Leetcode78 {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        List<List<Integer>> list = subsets(arr);

        System.out.println(list);
    }

    

    static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
           
        ArrayList<Integer> numbers = new ArrayList<>();
        for(int num : nums){
            numbers.add(num);
        }

        list.add(new ArrayList<>());
        return list;
    }

    
}
