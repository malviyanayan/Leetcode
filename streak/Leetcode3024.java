class Leetcode3024 {
    public int maxConsecutive(int bottom, int top, int[] special) {
        int max = 0;
        Arrays.sort(special);
        if (special[0] - bottom > max) {
            max = special[0] - bottom;
        }
        for (int i = 1; i < special.length; i++) {
            if (special[i] - special[i - 1] - 1 > max) {
                max = special[i] - special[i - 1] - 1;
            }
        }
        if (top - special[special.length - 1] > max) {
            max = top - special[special.length - 1];
        }
        return max;
    }
    public static void main(String[] args) {
        Leetcode3024 leetcode = new Leetcode3024();
        int bottom = 1;
        int top = 5;
        int[] special = {2, 3};
        System.out.println(leetcode.maxConsecutive(bottom, top, special)); // Output: 2
    }
}
// The code defines a class Leetcode3024 with a method maxConsecutive that calculates the maximum number of consecutive integers in a range [bottom, top] excluding the integers in the special array. The main method tests this functionality with an example.