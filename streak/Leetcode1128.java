class Leetcode1128 {
    public int numEquivDominoPairs(int[][] dominoes) {
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int[] domino : dominoes) {
            int a = domino[0];
            int b = domino[1];
            int key = a < b ? a * 10 + b : b * 10 + a;

            // If this key already exists, we found that many new pairs
            count += map.getOrDefault(key, 0);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        return count;
    }
}