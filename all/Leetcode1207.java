import java.util.TreeMap;
import java.util.TreeSet;

class Leetcode1207{
    static boolean uniqueO(int[] arr) {
        TreeMap<Integer,Integer> map = new TreeMap<>();

        for(int i:arr){
            map.put(i,map.getOrDefault(i, 0)+1);
        }
        TreeSet<Integer> set = new TreeSet<>(map.values());

        if(map.size() == set.size())return true;

        return false;
    }

    public static void main(String[] args) {
        
    }

}