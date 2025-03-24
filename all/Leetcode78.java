import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Leetcode78 {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        List<List<Integer>> list = subsets(arr);

        System.out.println(list);
    }

    

    static List<List<Integer>> subsets(int[] nums) {
        HashSet<ArrayList<Integer>> list = new HashSet<>();
        ArrayList<Integer> temp = new ArrayList<>();
        for(int nm : nums)temp.add(nm);

        helper(0,temp,list);

        List<List<Integer>> ans = new ArrayList<>(list);
        return ans;
    }

    private static void helper(int x,ArrayList<Integer> temp, HashSet<ArrayList<Integer>> list){
        if(list.size() <= 0 || x >= temp.size())return;

        ArrayList<Integer> l = new ArrayList<>();
        Integer current = temp.remove(x);
        l.add(current);
        list.add(l);

        list.add(temp);
        helper(x+1,temp, list);

        temp.add(current);
    }

    
}
