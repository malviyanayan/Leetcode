class Leetcode1780 {

    static int max = (int)Math.pow(3, 16);
    public static void main(String[] args) {
        // int n = 12;
        int n = 21;
        System.out.println(checkPowersOfThree(n));

    }

    static boolean checkPowersOfThree(int n) {
        String redixThree = Integer.toString(n,3);
        System.out.println(redixThree);
        if(redixThree.contains("2"))return false;

        return true;
    }
    
    
}
