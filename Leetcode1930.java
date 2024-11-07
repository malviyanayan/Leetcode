// 1930. Unique Length-3 Palindromic Subsequences

import java.util.HashMap;
import java.util.HashSet;

class Leetcode1930 {
    public static void main(String[] args) {
        int count = countPalindromicSubsequence("bbcbaba");
        System.out.println("Count is : " + count);
    }   
    
    static int countPalindromicSubsequence(String s) {
        int count = 0;
        HashMap<Character,Integer> first = new HashMap<>();
        HashMap<Character,Integer> last = new HashMap<>();

        for(char i = 'a';i<='z';i++){
            if(s.contains(i+"")){
                first.put(i, s.indexOf(i));
                last.put(i, s.lastIndexOf(i));
            }
        }

        for(Character key : first.keySet()){
            HashSet<Character> inner = new HashSet<>();
            for(int i = first.get(key)+1;i<last.get(key);i++){
                inner.add(s.charAt(i));
            }
            count += inner.size();
        }

        // System.out.println(first);
        // System.out.println(last);
      return count;  
    }
}
