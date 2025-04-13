import java.util.ArrayList;
import java.util.List;

class Leetcode139{
    static boolean wordBreak(String s, List<String> wordDict) {

        for(String next : wordDict){
            System.out.println(next + "- " + s);
            if(s.contains(next))s = s.replace(next , "");
        }

        return true;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("bbb");
        list.add("bbbb");

        System.out.println(wordBreak("bb", list));
    }
}