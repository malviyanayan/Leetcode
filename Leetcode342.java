class Leetcode342{
    public static void main(String[] args) {
        int n = 16;
        System.out.println(isPowerOfFour(n));
    }

    static boolean isPowerOfFour(int n) {
        if(n==0)return false;

        boolean flag = false;

        String str = Integer.toBinaryString(n);
        if(str.length()%2 == 1){
            flag = true;
            for(int i=1;i<str.length();i++){
                if(str.charAt(i) == '1')return false;
            }
        }

        return flag;
    }
}