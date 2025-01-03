class Leetcode326 {
    public static void main(String[] args) {
        
    }   
    

    // First version
    static boolean isPowerOfThree(int n) {
        if(n==1 || n == 3)return true;
        if(n%3 != 0 || n==0)return false;

        return isPowerOfThree(n/3);
    }

    static boolean isPowerOfThree1(int n) {
        if (n <= 0) return false;
        return (Math.log10(n) / Math.log10(3)) % 1 == 0;
    }
    
}
