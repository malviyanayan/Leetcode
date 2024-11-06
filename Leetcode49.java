// Group Anagrams

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

class Leetcode49 {
    public static void main(String[] args) {
        String[] allAnagrams = {"eat","tea","tan","ate","nat","bat"};
        groupAnagrams(allAnagrams);
    }

    static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,HashMap<Character,Integer>> map = new HashMap<>();
        for(String str : strs){
            HashMap<Character,Integer> strMap = new HashMap<>();
            for(int i=0;i<str.length();i++)strMap.put(str.charAt(i),strMap.getOrDefault(str.charAt(i), 0)+1);

            map.put(str, strMap);
        }

        List<List> ans = new ArrayList<>();
        Set<String> keys = map.keySet();

        while (keys.size() !=0 ) {
            
        }

        return null;
    }
}
