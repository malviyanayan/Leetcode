import java.util.TreeMap;

public class Prac {
    public static void main(String[] args) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        map.put(2,3);
        map.put(2, null);


        System.out.println("contains : " + map.containsKey(2));
    }
}
