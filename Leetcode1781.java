import java.util.HashMap;

public class Leetcode1781 {
    static int beautySum(String s) {
        int beautySum = 0;

        // Iterate over each substring
        for (int i = 0; i < s.length(); i++) {
            HashMap<Character, Integer> freqMap = new HashMap<>();

            for (int j = i; j < s.length(); j++) {
                // Update the frequency of the current character
                char ch = s.charAt(j);
                freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);

                // Calculate beauty for this substring
                int maxFreq = Integer.MIN_VALUE;
                int minFreq = Integer.MAX_VALUE;

                for (int freq : freqMap.values()) {
                    if (freq > maxFreq) maxFreq = freq;
                    if (freq < minFreq) minFreq = freq;
                }

                beautySum += (maxFreq - minFreq);
            }
        }

        return beautySum;
    }

    public static void main(String[] args) {
        String s = "aabcb";
        int bs = beautySum(s);
        System.out.println("Beauty Sum = " + bs);
    }
}
