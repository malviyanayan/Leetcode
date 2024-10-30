import java.util.HashMap;
import java.util.Set;

class Leetcode242 {
    public static void main(String[] args) {
        // String s = "anagram", t = "nagaram";
        String s = "rat", t = "car";
        System.out.println("isAnagram : " + isAnagram(s, t));
    }

    static boolean isAnagram(String s, String t) {
        if(s.length() != t.length())return false;

        HashMap<Character,Integer> map1 = new HashMap<>();
        HashMap<Character,Integer> map2 = new HashMap<>(); 

        for(int i=0;i<s.length();i++){
            map1.put(s.charAt(i), map1.getOrDefault(s.charAt(i),0)+1);
            map2.put(t.charAt(i), map2.getOrDefault(t.charAt(i),0)+1);
        }

        Set<Character> keys = map1.keySet();
        

        for(Character key : keys){
            if(map2.containsKey(key)){
                if(map1.get(key) == map2.get(key))continue;
                else return false;
            }else return false;
        }
        
        return true;
    }
}
