class Leetcode231 {
    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(4));
    }


    static boolean isPowerOfTwo(int number) {
        if (number <= 0) {
            return false;
        }
        return (number & (number - 1)) == 0;
    }
}