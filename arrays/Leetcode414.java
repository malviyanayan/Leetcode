import java.util.TreeSet;

class Leetcode414 {

    public int thirdMax(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        for(int num : nums){
            set.add(num);
            if(set.size() > 3){
                set.remove(set.first());
            }

        }


        if(set.size() == 2){
            set.remove(set.first());
        }
        return set.first();
    }


    public static void main(String[] args){

    }    
}
