import java.util.ArrayList;

class Leetcode2900 {

    public List<String> getWordsInLongestSubsequence(int n, String[] words, int[] groups) {
        List<String> ans = new ArrayList<>();
        int groupId = -1;

        for (int i = 0; i < n; ++i)
            if (groups[i] != groupId) {
                groupId = groups[i];
                ans.add(words[i]);
            }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}