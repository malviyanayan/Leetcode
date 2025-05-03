class Leetcode1007{
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int result = check(tops[0], tops, bottoms);
        if (result != -1) {
            return result;
        } else {
            return check(bottoms[0], tops, bottoms);
        }
    }

    private int check(int x, int[] tops, int[] bottoms) {
        int rotationsTop = 0;
        int rotationsBottom = 0;
        int n = tops.length;

        for (int i = 0; i < n; i++) {
            if (tops[i] != x && bottoms[i] != x) {
                return -1; // Can't make all values equal to x
            } else if (tops[i] != x) {
                rotationsTop++; // Need to rotate top to get x
            } else if (bottoms[i] != x) {
                rotationsBottom++; // Need to rotate bottom to get x
            }
        }
        return Math.min(rotationsTop, rotationsBottom);
    }
}