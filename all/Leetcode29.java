public class Leetcode29 {
    public static void main(String[] args) {
        // int dd = 10;
        // int dv = 3;
        // int dd = 7;
        // int dv = -3;
        // int dd = 1;
        // int dv = 1;
        // int dd = -1;
        // int dv = 1;
        // int dd = 10;
        // int dv = 2;
        // int dd = 1;
        // int dv = 3;
        // int dd = -15;
        // int dv = -3;
        int dd = 2147483647;
        int dv = 1;

        System.out.println(divide(dd, dv));
    }

    public int divide1(int dividend, int divisor) {
        int y = dividend;
        int x = divisor;
        if(y<0)y = -(y);
        if(x<0)x = -(x);
        int count = 0;
        int ans = 0;
        

        count = 0;

        while((ans+x) <= y){
            ans = x+ans;
            count++;
        }
        
        if((divisor<0 && dividend<0) || (divisor > 0 && dividend >0));
        else count = -(count);

        return count;
    }


    static int divide2(int dividend, int divisor) {
        if(dividend==0)return 0;
        boolean sign = false;
        if((dividend >= 0 && divisor > 0) || (!(dividend >= 0) && !(divisor > 0)))sign = true;

        int count = 0;
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        int temp = 0;


        // System.out.println("hjggjhgjg");
        while((temp = temp + divisor) <= dividend){
            count++;
        }

        if(sign) return count;


        return -count;
    }

    public static int divide(int dividend, int divisor) {
        // Handle overflow case
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
    
        // Determine the sign of the result
        boolean positive = (dividend >= 0) == (divisor > 0);
    
        // Work with absolute values
        long absDividend = Math.abs((long) dividend);
        long absDivisor = Math.abs((long) divisor);
    
        int result = 0;
    
        // Perform division using subtraction and bit-shifting
        while (absDividend >= absDivisor) {
            long tempDivisor = absDivisor, multiple = 1;
            while (absDividend >= (tempDivisor << 1)) {
                tempDivisor <<= 1;
                multiple <<= 1;
            }
            absDividend -= tempDivisor;
            result += multiple;
        }
    
        return positive ? result : -result;
    }
    
}
