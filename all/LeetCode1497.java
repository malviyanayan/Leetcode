import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

class LeetCode1497 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 10, 6, 7, 8, 9};
        int k = 5;
        // int[] arr = {-1,1,-2,2,-3,3,-4,4};
        // int k = 3;

        System.out.println(canArrange(arr, k));
    }

    static boolean canArrange(int[] arr, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int count = 0;

        for (int i : arr) {
            map.put(i % k, map.getOrDefault(i % k, 0) + 1);
        }

        Set<Integer> st = map.keySet();
        List<Integer> toRemove = new ArrayList<>();

        for (Integer key : st) {
            if (toRemove.contains(key)) continue;

            int val = k - key;

            if (map.containsKey(val)) {
                if (map.get(key).equals(map.get(val))) {
                    count += map.get(key);
                    toRemove.add(key);
                    toRemove.add(val);
                } else if (map.get(key) < map.get(val)) {
                    map.put(val, map.get(val) - map.get(key));
                    count += map.get(key);
                    toRemove.add(key);
                } else {
                    map.put(key, map.get(key) - map.get(val));
                    count += map.get(val);
                    toRemove.add(val);
                }
            } else {
                count += map.get(key) / 2;
                map.put(key, map.get(key) % 2);
                if (map.get(key) == 0) toRemove.add(key);
            }
        }

        for (Integer key : toRemove) {
            map.remove(key);
        }

        System.out.println(count);

        return count >= arr.length / 2;
    }
}

