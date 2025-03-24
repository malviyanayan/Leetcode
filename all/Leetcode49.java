// Group Anagrams

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Arrays;


class Leetcode49 {
    public static void main(String[] args) {
        String[] allAnagrams = { "eat", "tea", "tan", "ate", "nat", "bat" };
        // String[] allAnagrams = {""};
        // String[] allAnagrams = {"a"};
        System.out.println(groupAnagrams(allAnagrams));

    }

    static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        ArrayList<String> list = new ArrayList<>(Arrays.asList(strs));

        while (!list.isEmpty()) {
            String str = list.remove(0);
            HashMap<Character, Integer> map = new HashMap<>();
            for (char c : str.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }

            List<String> tempList = new ArrayList<>();
            tempList.add(str);

            int i = 0;
            while (i < list.size()) {
                String str1 = list.get(i);
                if (areAnagrams(map, str1)) {
                    tempList.add(list.remove(i));
                } else {
                    i++;
                }
            }

            ans.add(tempList);
        }

        return ans;
    }

    private static boolean areAnagrams(HashMap<Character, Integer> map, String str) {
        HashMap<Character, Integer> map1 = new HashMap<>();
        for (char c : str.toCharArray()) {
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }
        return map.equals(map1);
    }

}
